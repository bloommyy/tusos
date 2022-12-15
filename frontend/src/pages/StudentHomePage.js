import desk from "../assets/desk.png";
import fridge from "../assets/fridge.png";
import bill from "../assets/bill.png";

function StudentHomePage() {
    const userJSON = JSON.parse(localStorage.getItem('user'));

    return (<div>
        <div class="container py-2">
            <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
            <a href="#" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <span class="fs-4">Технически университет - София</span>
            </a>

            <ul class="nav nav-pills">
                <li class="nav-item"><a href="#" class="nav-link active" aria-current="page">Изход</a></li>
            </ul>
            </header>
        </div>
        <div class="container py-2">
             <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
                <h1 class="display-4 fw-normal">Студентски общежития и столове</h1>
                <p class="fs-5 text-muted">Можете да управлявате своите ресурси и да плащате таксите си онлайн в портала на СОС, като изберете от предоставените опции</p>
             </div>
             <div class="row row-cols-1 row-cols-md-3 mb-3 mt-5 text-center">
             <div class="col">
                <div class="card mb-4 rounded-3 shadow-sm border-primary">
                <div class="card-header py-3 text-white bg-primary border-primary">
                    <h4 class="my-0 fw-normal">Мебели</h4>
                </div>
                <div class="card-body">

                     {/*Redirect to add furniture page*/}
                     
                    <a href="#">
                        <div className="panel-body"><img src={desk} className="img-responsive" width="40%" alt="Image" /></div>
                    </a>
                </div>
                </div>
            </div>
            <div class="col">
                <div class="card mb-4 rounded-3 shadow-sm border-primary">
                <div class="card-header py-3 text-white bg-primary border-primary">
                    <h4 class="my-0 fw-normal">Електроуреди</h4>
                </div>
                <div class="card-body">
                    <a href="#">
                        <div className="panel-body"><img src={fridge} className="img-responsive" width="40%" alt="Image" /></div>
                    </a>
                </div>
                </div>
            </div>
            <div class="col">
                <div class="card mb-4 rounded-3 shadow-sm border-primary">
                <div class="card-header py-3 text-white bg-primary border-primary">
                    <h4 class="my-0 fw-normal">Сметки</h4>
                </div>
                <div class="card-body">
                    <a href="#">
                        <div className="panel-body"><img src={bill} className="img-responsive" width="40%" alt="Image" /></div>
                    </a>
                </div>
                </div>
            </div>
        </div>
        </div>
        </div>)
}
export default StudentHomePage;