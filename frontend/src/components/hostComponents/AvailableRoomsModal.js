import { useEffect, useState } from "react"
import { addStudentToRoom, getAvailableDorms, getAvailableRoomsForDorm } from "../../actions/getRequests"
import ReactPaginate from 'react-paginate';

function AvailableRoomsModal() {
    const [availableDorms, setAvailableDorms] = useState([])
    const [availableRooms, setAvailableRooms] = useState([])
    const [chosenDorm, setChosenDorm] = useState(0)

    useEffect(() => {
        getAvailableDorms().then((result) => setAvailableDorms(result))
    }, [])

    function changedDormSelect(choice) {
        setChosenDorm(choice.target.value)
        getAvailableRoomsForDorm(choice.target.value).then((result) => setAvailableRooms(result))
    }
    function FillSelectOptions(result) {
        let keyIter = 0
        return result.map((element) => {
            return <option key={keyIter++} result={element}>{element}</option>
        })
    }
    function Items({ currentItems }) {
        return (
          <table class="table">
          <thead>
              <tr>
                  <th>Номер на стая</th>
                  <th>Блок</th>
              </tr>
          </thead>
          <tbody>{currentItems &&
              currentItems.map((item) => (
                <tr>
                            <td>{item}</td>
                            <td>{chosenDorm}</td>
                </tr>
              ))}
          </tbody>
      </table>
        );
      }
      function PaginatedItems({ itemsPerPage }) {
        // Here we use item offsets; we could also use page offsets
        // following the API or data you're working with.
        const [itemOffset, setItemOffset] = useState(0);
      
        // Simulate fetching items from another resources.
        // (This could be items from props; or items loaded in a local state
        // from an API endpoint with useEffect and useState)
        const endOffset = itemOffset + itemsPerPage;
        console.log(`Loading items from ${itemOffset} to ${endOffset}`);
        const currentItems = availableRooms.slice(itemOffset, endOffset);
        const pageCount = Math.ceil(availableRooms.length / itemsPerPage);
      
        // Invoke when user click to request another page.
        const handlePageClick = (event) => {
          const newOffset = (event.selected * itemsPerPage) % availableRooms.length;
          console.log(
            `User requested page number ${event.selected}, which is offset ${newOffset}`
          );
          setItemOffset(newOffset);
        };

        return (
            <>
              <Items currentItems={currentItems} />
              <ReactPaginate
                 previousLabel="previous"
                 nextLabel="next"
                 breakLabel="..."
                 breakClassName="page-item"
                 breakLinkClassName="page-link"
                 marginPagesDisplayed={2}
                 containerClassName="pagination justify-content-center"
                 pageClassName="page-item"
                 pageLinkClassName="page-link"
                 previousClassName="page-item"
                 previousLinkClassName="page-link"
                 nextClassName="page-item"
                 nextLinkClassName="page-link"
                 activeClassName="active"
                onPageChange={handlePageClick}
                pageRangeDisplayed={5}
                pageCount={pageCount}
                renderOnZeroPageCount={null}
              />
            </>
          );
    }

    return(
        <div>
            <div className="mb-3">
                <label>Изберете блок</label>
                <select onChange={(value) => changedDormSelect(value)} className="form-select" aria-label="Default select example">
                    <option key="">Изберете блок</option>
                    {FillSelectOptions(availableDorms)}
                </select >
            </div>

              <PaginatedItems itemsPerPage={10} />
        </div>
    )
}
export default AvailableRoomsModal