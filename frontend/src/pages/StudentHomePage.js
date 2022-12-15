import desk from "../assets/desk.png";
import fridge from "../assets/fridge.png";
import bill from "../assets/bill.png";

function StudentHomePage() {
    const userJSON = JSON.parse(localStorage.getItem('user'));

    return (
        <div>
            <nav className="navbar navbar-light" >
                <div className="navbar-header">
                    <a className="navbar-brand" href="#">ТЕХНИЧЕСКИ УНИВЕРСИТЕТ - СОФИЯ</a>
                </div>
                <div className="collapse navbar-collapse" id="myNavbar">
                    <ul className="nav navbar-nav navbar-right">
                        <li><a href="#"><span className="glyphicon glyphicon-user"></span> изход</a></li>
                    </ul>
                </div>
            </nav>
            <div className="jumbotron col align-self-center bg-image">
                <div className="container text-center">
                    <h1><span className="text-primary">Студентски общежития и столове</span></h1>
                    <p>Можете да управлявате своите ресурси и да плащате таксите си онлайн в портала на СОС, като изберете от предоставените опции</p>
                </div>
            </div>
            <div className="container">
                <div className="row">
                    <div className="col-xs-4" align="center">
                        <div className="panel panel-primary">
                            <div className="panel-heading">мебели</div>
                            <a href="#">
                                <div className="panel-body"><img src={desk} className="img-responsive" width="50%" alt="Image" /></div>
                            </a>
                        </div>
                    </div>
                    <div className="col-xs-4" align="center">
                        <div className="panel panel-danger">
                            <div className="panel-heading">електроуреди</div>
                            <a href="#">
                                <div className="panel-body"><img src={fridge} className="img-responsive" width="50%" alt="Image" /></div>
                            </a>
                        </div>
                    </div>
                    <div className="col-xs-4" align="center">
                        <div className="panel panel-success">
                            <div className="panel-heading">сметки</div>
                            <a href="#">
                                <div className="panel-body"><img src={bill} className="img-responsive" width="50%" alt="Image" /></div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
export default StudentHomePage;