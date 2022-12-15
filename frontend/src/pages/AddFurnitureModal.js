function AddFurnitureModal() {
    const userJSON = JSON.parse(localStorage.getItem('user'));

    return (<div>
        <div class="container-sm" id="exampleModal">
            <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Добави мебели</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-outline mb-4">
                            <label class="form-label">Вид мебел</label>
                            <input type="email" id="nameInput" class="form-control" />
                        </div>
                        <select class="form-select" aria-label="Default select example">
                            <option selected>Състояние</option>
                            <option value="1">Здраво</option>
                            <option value="2">Счупено</option>
                        </select>
                    </form>
                </div>
                <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Отказ</button>
                <button type="button" class="btn btn-primary">Запази промените</button>
                </div>
            </div>
            </div>
        </div>
        </div>)
}
export default AddFurnitureModal;