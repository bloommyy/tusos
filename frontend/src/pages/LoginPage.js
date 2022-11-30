import React, { useState } from 'react';
//import { AppContainer, BoxContainer, TopContainer, HeaderContainer, HeaderText, InnerContainer, FormContainer, Input, SubmitButton } from '../components/LoginFormCSS';
import { connect } from 'react-redux';
import { login } from '../actions/auth';
import logo from "../assets/logo-tu.png";

function Alert(props) {
    return //<MuiAlert elevation={6} variant="filled" {...props} />;
}

export default connect(({ error }) => ({ error }), { login })(props => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");

    function btnOnClick() {
        if (email === "" || password === "") {
            alert("Не сте въвели e-mail или парола.");
            return;
        }

        props.login({ email, password });
    }

    return (<div>
        <div> 
           <section class="">
                <div class="px-4 py-5 px-md-5 text-center text-lg-start bg-light">
                <div class="container">
                    <div class="row gx-lg-5 align-items-center">
                    <div class="col-lg-6 mb-4">
                        <h1 class="my-4 display-3 fw-bold ls-tight">
                        <img src={logo} class="mx-auto d-block" width="50%"  alt="tu-sofia logo"/>
                        <span class="text-primary">Студентски общежития и столове</span>
                        </h1>
                        <p class="text-secondary">
                        Уеб портал към Технически университет - София за настаняване на настоящи студенти в общежития.
                        Регистрационната форма се попълва с валидни данни за съответния студент.
                        </p>
                    </div>
                    <div class="col-lg-6 mb-5 mb-lg-0">
                        <div class="card">
                            <div class="card-body py-5 px-md-5">
                                <form>        
                                <div class="form-outline mb-4">
                                    <input type="password" id="facultynumInput" class="form-control" />
                                    <label class="form-label">Факултетен номер</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="password" id="passwordInput" class="form-control" />
                                    <label class="form-label">Парола</label>
                                </div>
                
                                <button type="submit" class="btn btn-primary btn-block">
                                    Вход
                                </button>

                                <div class="form-outline mt-4">
                                    
                                    {/*add link to registerPage.js in href property*/}
                                    <p>За нов потребител: <a href="#!" class="link-info"> Регистрация</a></p>
                                </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    </div>
                </div>
                </div>
            </section>
        </div>)
    </div>)
});
