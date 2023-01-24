import { useState } from "react";
import AddRoomsModal from "./AddRoomsModal";
import AvailableRoomsModal from "./AvailableRoomsModal";

function ManageRoomsModal({ btnOnClick }) {
    const [addFlag, setAddFlag] = useState(true);
    const [getFlag, setGetFlag] = useState(false);

    return (<div>
        
        <div className="row row-cols-1 row-cols-md-6 mb-3 mt-5 text-center">
        <div className="col">
            <div className="card mb-6 rounded-3 shadow-sm border-primary" onClick={function() {setAddFlag(true); setGetFlag(false)}} >
                <div className="card-header py-3 text-white bg-primary border-primary">
                    <h4 className="my-0 fw-normal">Добавяне на стаи</h4>
                </div>
            </div>
        </div>
        <div className="col">
            <div className="card mb-6 rounded-3 shadow-sm border-primary" onClick={function() {setAddFlag(false); setGetFlag(true)}}>
                <div className="card-header py-3 text-white bg-primary border-primary">
                    <h4 className="my-0 fw-normal">Преглед на свободни стаи</h4>
                </div>
            </div>
        </div>
       
    </div> 
        {addFlag && <AddRoomsModal btnOnClick={btnOnClick} />}
        {getFlag && <AvailableRoomsModal closed={btnOnClick} />}
    </div>)
}

export default ManageRoomsModal;