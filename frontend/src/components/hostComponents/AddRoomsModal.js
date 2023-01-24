import React, { useState } from 'react';
import { connect } from 'react-redux';
import { addAllDormRooms } from '../../actions/customAPI'

export default connect(({ error }) => ({ error }), { addAllDormRooms })((props) => {
    let closed;
    const [floorCount, setFloorCount] = useState(0);
    const [roomsPerFloorCount, setRoomsPerFloorCount] = useState(0);
    const [dormId, setDormId] = useState("");

    function btnOnClick(e) {
        e.preventDefault()

        if (dormId === "") {
            alert("Не сте въвели номер на блока.");
            return;
        }

        props.addAllDormRooms({ dormId, floorCount, roomsPerFloorCount });
    }

    return (<div>
        <div className="container-sm" id="exampleModal">
            <div className="modal-dialog">
                <div className="modal-content">
                    <div className="modal-header">
                        <h5 className="modal-title" id="exampleModalLabel">Добавяне на стаи в блок</h5>
                        <button type="button" onClick={closed} className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div className="modal-body">
                        <form>
                            <div className="form-outline mb-4">
                                <label className="form-label">Номер на блока</label>
                                <input id="dormIdInput" onChange={input => setDormId(input.target.value)} className="form-control" />
                            </div>
                            <div className="form-outline mb-4">
                                <label className="form-label">Брой етажи</label>
                                <input id="nameInput" type="number" onChange={input => setFloorCount(input.target.value)} className="form-control" />
                            </div>
                            <div className="form-outline mb-4">
                                <label className="form-label">Брой стаи на етаж</label>
                                <input id="nameInput" type="number" onChange={input => setRoomsPerFloorCount(input.target.value)} className="form-control" />
                            </div>
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