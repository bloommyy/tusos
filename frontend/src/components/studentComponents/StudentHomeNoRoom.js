import { useEffect, useState } from "react"
import { addStudentToRoom, getAvailableDorms, getAvailableRoomsForDorm } from "../../actions/getRequests"

function StudentHomeNoRoom() {
    const [availableDorms, setAvailableDorms] = useState([])
    const [availableRooms, setAvailableRooms] = useState([])
    const [chosenDorm, setChosenDorm] = useState(0)
    const [chosenRoom, setChosenRoom] = useState(0)

    useEffect(() => {
        getAvailableDorms().then((result) => setAvailableDorms(result))
    }, [])

    function changedDormSelect(choice) {
        setChosenDorm(choice.target.value)
        getAvailableRoomsForDorm(choice.target.value).then((result) => setAvailableRooms(result))
    }

    function btnOnClick(e) {
        e.preventDefault()

        console.log("dorm - ", chosenDorm, " room - ", chosenRoom)
        if (chosenDorm === 0 || chosenRoom === 0) {
            alert("Не е избрана стая.")
            return
        }

        addStudentToRoom(chosenDorm, chosenRoom).then((result) => alert(result))
    }

    return (
        <form>
            <legend className="">Настаняване в общежитие</legend>
            <div className="mb-3">
                <label>Изберете блок</label>
                <select onChange={(value) => changedDormSelect(value)} className="form-select" aria-label="Default select example">
                    {FillSelectOptions(availableDorms)}
                </select >
            </div>
            <div className="mb-3">
                <label>Изберете стая</label>
                <select onChange={(value) => setChosenRoom(value.target.value)} className="form-select" aria-label="Default select example">
                    {FillSelectOptions(availableRooms)}
                </select >
            </div>
            <button onClick={btnOnClick} type="submit" className="btn btn-primary mb-3">Настани ме</button>
        </form>
    )
}

function FillSelectOptions(result) {
    let keyIter = 0
    return result.map((element) => {
        return <option key={keyIter++} result={element}>{element}</option>
    })
}

export default StudentHomeNoRoom;