import desk from "../assets/desk.png";
import fridge from "../assets/fridge.png";
import bill from "../assets/bill.png";

function StudentHomePage() {
    const userJSON = JSON.parse(localStorage.getItem('user'));

    return (
        <div>
           <nav class="navbar navbar-light" >
                <div class="navbar-header">
                <a class="navbar-brand" href="#">ТЕХНИЧЕСКИ УНИВЕРСИТЕТ - СОФИЯ</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> изход</a></li>
                </ul>
                </div>
            </nav>
            <div class="jumbotron col align-self-center bg-image">
                <div class="container text-center">
                <h1><span class="text-primary">Студентски общежития и столове</span></h1>     
                <p>Можете да управлявате своите ресурси и да плащате таксите си онлайн в портала на СОС, като изберете от предоставените опции</p>
                </div>
            </div>
            <div class="container">    
                <div class="row">
                    <div class="col-xs-4" align="center">
                        <div class="panel panel-primary">
                            <div class="panel-heading">мебели</div>
                            <a href="#">
                                <div class="panel-body"><img src={desk} class="img-responsive" width="50%" alt="Image"/></div>
                            </a>
                        </div>
                    </div>
                    <div  class="col-xs-4" align="center"> 
                        <div class="panel panel-danger">
                            <div class="panel-heading">електроуреди</div>
                            <a href="#">
                                <div class="panel-body"><img src={fridge} class="img-responsive" width="50%" alt="Image"/></div>
                            </a>
                        </div>
                    </div>
                    <div  class="col-xs-4" align="center"> 
                        <div class="panel panel-success">
                            <div class="panel-heading">сметки</div>
                            <a href="#">
                                <div class="panel-body"><img src={bill} class="img-responsive" width="50%" alt="Image"/></div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
export default StudentHomePage;