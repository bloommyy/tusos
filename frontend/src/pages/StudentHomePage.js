import { useEffect, useState } from "react";
import StudentHomeMenusWrapper from "../components/studentComponents/StudentHomeMenusWrapper";
import { hasRoom } from "../actions/getRequests";
import StudentHomeNoRoom from "../components/studentComponents/StudentHomeNoRoom";
import { logout } from '../actions/auth';
import { connect } from 'react-redux';

export default connect(({ error }) => ({ error }), { logout })(props => {
    const [studentHasRoom, setStudentHasRoom] = useState(false)

    useEffect(() => {
        hasRoom().then((value) => setStudentHasRoom(value))
    })

    const [furnitureFlag, setFurnitureFlag] = useState(false);
    const [applianceFlag, setApplianceFlag] = useState(false);

    function btnOnClick() {
        setFurnitureFlag(!furnitureFlag);
    }
    function btnApplianceOnClick() {
        setApplianceFlag(!applianceFlag);
    }

    function logOut() {
        console.log("aaaaaa")
        props.logout()
    }

    return (<div>
        <div className="container py-2">
            <header className="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <a href="#" className="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                    <span className="fs-4">Технически университет - София</span>
                </a>

                <ul className="nav nav-pills">
                    <li className="nav-item"><a role="button" onClick={logOut} className="nav-link active pe-auto" aria-current="page">Изход</a></li>
                </ul>
            </header>
        </div>
        <div className="container py-2">
            <div className="pricing-header p-3 pb-md-4 mx-auto text-center">
                <h1 className="display-4 fw-normal">Студентски общежития и столове</h1>
                <p className="fs-5 text-muted">Можете да управлявате своите ресурси и да плащате таксите си онлайн в портала на СОС, като изберете от предоставените опции</p>
            </div>
            {studentHasRoom ? <StudentHomeMenusWrapper furnitureFlag={furnitureFlag} btnOnClick={btnOnClick} /> : <StudentHomeNoRoom />}
        </div>
    </div>)
})