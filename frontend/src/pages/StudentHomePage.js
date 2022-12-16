import { useState } from "react";
import AddFurnitureModal from "./AddFurnitureModal";
import StudentHomeMenu from "../components/StudentHomeMenu";
import AddApplianceModal from "./AddApplianceModal";

function StudentHomePage() {
    const userJSON = JSON.parse(localStorage.getItem('user'));

    const [furnitureFlag, setFurnitureFlag] = useState(false);
    const [applianceFlag, setApplianceFlag] = useState(false);

    function btnOnClick() {
        setFurnitureFlag(!furnitureFlag);
    }
    function btnApplianceOnClick() {
        setApplianceFlag(!applianceFlag);
    }

    return (<div>
        <div className="container py-2">
            <header className="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <a href="#" className="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                    <span className="fs-4">Технически университет - София</span>
                </a>

                <ul className="nav nav-pills">
                    <li className="nav-item"><a href="#" className="nav-link active" aria-current="page">Изход</a></li>
                </ul>
            </header>
        </div>
        <div className="container py-2">
            <div className="pricing-header p-3 pb-md-4 mx-auto text-center">
                <h1 className="display-4 fw-normal">Студентски общежития и столове</h1>
                <p className="fs-5 text-muted">Можете да управлявате своите ресурси и да плащате таксите си онлайн в портала на СОС, като изберете от предоставените опции</p>
            </div>
            {!furnitureFlag && <StudentHomeMenu btnOnClick={btnOnClick} />}
            {furnitureFlag && <AddFurnitureModal closed={btnOnClick} />}
        </div>
    </div>)
}
export default StudentHomePage;