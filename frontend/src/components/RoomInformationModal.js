import { connect } from 'react-redux';
import { login } from '../actions/auth';

export default connect(({ error }) => ({ error }), { login })(({ closed }) => {
    const userJSON = JSON.parse(localStorage.getItem('user'));

    return (<div>
        <div className="container-sm" id="exampleModal">
            <div className="modal-dialog">
                <div className="modal-content">
                    <div className="modal-header">
                        <h5 className="modal-title" id="exampleModalLabel">Добави мебели</h5>
                        <button type="button" onClick={closed} className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div className="modal-body">
                        <form>
                            <div className="form-outline mb-4">
                                <label className="form-label">Вид мебел</label>
                                <input type="email" id="nameInput" className="form-control" />
                            </div>
                            <select className="form-select" aria-label="Default select example">
                                <option defaultValue={'Състояние'} />
                                <option value="1">Здраво</option>
                                <option value="2">Счупено</option>
                            </select>
                        </form>
                    </div>
                    <div className="modal-footer">
                        <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Отказ</button>
                        <button type="button" className="btn btn-primary">Запази промените</button>
                    </div>
                </div>
            </div>
        </div>
    </div>)
})