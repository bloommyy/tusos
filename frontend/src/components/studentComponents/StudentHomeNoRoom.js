import { useEffect } from "react"
import { getAllRooms } from "../../actions/getRequests"

function StudentHomeNoRoom() {
    useEffect(() => {
        getAllRooms().then((result) => console.log(result))
    })

    return (
        <form>
            <legend className="">Настаняване в общежитие</legend>
            <div className="mb-3">
                <label>Изберете блок</label>
                <select className="form-select" aria-label="Default select example">
                    {FillSelectOptions([2, 3, 5])}
                </select >
            </div>
            <div className="mb-3">
                <label>Изберете етаж</label>
                <select className="form-select" aria-label="Default select example">
                    {FillSelectOptions([1, 2, 3])}
                </select >
            </div>
            <div className="mb-3">
                <label>Изберете стая</label>
                <select className="form-select" aria-label="Default select example">
                    {FillSelectOptions([4, 5, 6])}
                </select >
            </div>
            <button type="submit" className="btn btn-primary mb-3">Настани ме</button>
        </form>
    )
}

function FillSelectOptions(result) {
    let keyIter = 0
    return result.map((dormId) => {
        return <option key={keyIter++} result={dormId}>{dormId}</option>
    })
}

export default StudentHomeNoRoom;