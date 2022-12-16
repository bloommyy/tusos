import React, { useState } from 'react';
import { connect } from 'react-redux';
import { addAppliance } from '../actions/roomOperations';

export default connect(({ error }) => ({ error }), { addAppliance})((props)  => {
    let closed ;
    const [applianceName, setApplianceName] = useState("");

    function btnOnClick(e) {
        e.preventDefault()

        if (applianceName === "") {
            alert("Не сте въвели вид електроуред.");
            return;
        }

        props.addAppliance({ applianceName });
    }

    return (<div>
        <div className="container-sm" id="exampleModal">
            <div className="modal-dialog">
                <div className="modal-content">
                    <div className="modal-header">
                        <h5 className="modal-title" id="exampleModalLabel">Добави електроуред</h5>
                        <button type="button" onClick={closed} className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div className="modal-body">
                        <form>
                            <div className="form-outline mb-4">
                                <label className="form-label">Вид електроуред</label>
                                <input id="nameInput" onChange={input => setApplianceName(input.target.value)} className="form-control" />
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