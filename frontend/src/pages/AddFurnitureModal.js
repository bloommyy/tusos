import React, { useState } from 'react';
import { connect } from 'react-redux';
import { addFurniture, viewFurniture } from '../actions/roomOperations';

export default connect(({ error }) => ({ error }), { addFurniture, viewFurniture })((props) => {
    const [furnitureName, setFurnitureName] = useState("");
    const [isBroken, setIsBroken] = useState(false);

    function btnOnClick(e) {
        e.preventDefault()

        if (furnitureName === "") {
            alert("Не сте въвели вид мебел.");
            return;
        }

        props.addFurniture({ furnitureName, isBroken });
    }

    function viewRoomFurniture(e) {
        e.preventDefault()

        props.viewFurniture();
    }

    return (<div>
        <div className="container-sm" id="exampleModal">
            <div className="modal-dialog">
                <div className="modal-content">
                    <button type="submit" onClick={viewRoomFurniture} className="btn btn-primary">Виж текущите мебели</button>
                    <div className="modal-header">
                        <h5 className="modal-title" id="exampleModalLabel">Добави мебели</h5>
                        <button type="button" onClick={props.closed} className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div className="modal-body">
                        <form>
                            <div className="form-outline mb-4">
                                <label className="form-label">Вид мебел</label>
                                <input id="nameInput" onChange={input => setFurnitureName(input.target.value)} className="form-control" />
                            </div>
                            <select className="form-select" onSelect={input => setIsBroken(false)} aria-label="Default select example">
                                <option defaultValue={'Състояние'} />
                                <option value="false">Здраво</option>
                                <option value="true">Счупено</option>
                            </select>
                        </form>
                    </div>
                    <div className="modal-footer">
                        <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Отказ</button>
                        <button type="submit" onClick={btnOnClick} className="btn btn-primary">Запази промените</button>
                    </div>
                </div>
            </div>
        </div>
    </div>)
})