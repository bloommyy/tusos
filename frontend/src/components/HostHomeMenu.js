import desk from "../assets/desk.png";
import fridge from "../assets/fridge.png";
import bill from "../assets/bill.png";

function HostHomePage({ btnOnClick }) {
    return (<div className="row row-cols-1 row-cols-md-3 mb-3 mt-5 text-center">
        <div className="col">
            <div className="card mb-4 rounded-3 shadow-sm border-primary">
                <div className="card-header py-3 text-white bg-primary border-primary">
                    <h4 className="my-0 fw-normal">Управление на стаи</h4>
                </div>
                <div className="card-body">
                    <a href="#">
                        <div className="panel-body"><img src={desk} onClick={btnOnClick} className="img-responsive" width="40%" alt="Image" /></div>
                    </a>
                </div>
            </div>
        </div>
        <div className="col">
            <div className="card mb-4 rounded-3 shadow-sm border-primary">
                <div className="card-header py-3 text-white bg-primary border-primary">
                    <h4 className="my-0 fw-normal">Електроуреди</h4>
                </div>
                <div className="card-body">
                    <a href="#">
                        <div className="panel-body"><img src={fridge} className="img-responsive" width="40%" alt="Image" /></div>
                    </a>
                </div>
            </div>
        </div>
        <div className="col">
            <div className="card mb-4 rounded-3 shadow-sm border-primary">
                <div className="card-header py-3 text-white bg-primary border-primary">
                    <h4 className="my-0 fw-normal">Сметки</h4>
                </div>
                <div className="card-body">
                    <a href="#">
                        <div className="panel-body"><img src={bill} className="img-responsive" width="40%" alt="Image" /></div>
                    </a>
                </div>
            </div>
        </div>
    </div>)
}

export default HostHomePage;