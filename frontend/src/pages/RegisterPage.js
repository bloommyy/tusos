import React, { useState } from 'react';
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

    {/*add other props used for registration*/}


    return (<div>
            <section class="">
            <div class="px-4 py-5 px-md-5 text-center text-lg-start" style="background-color: hsl(0, 0%, 96%)">
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
                                <input type="email" id="nameInput" class="form-control" />
                                <label class="form-label">Име</label>
                            </div>
                            <div class="form-outline mb-4">
                                <input type="email" id="surnameInput" class="form-control" />
                                <label class="form-label">Презиме</label>
                            </div>
                            <div class="form-outline mb-4">
                                <input type="email" id="emailInput" class="form-control" />
                                <label class="form-label">Фамилия</label>
                            </div>
                            <div class="form-outline mb-4">
                                <input type="email" id="emailInput" class="form-control" />
                                <label class="form-label">Email</label>
                            </div>
        
                            <div class="form-outline mb-4">
                                <input type="password" id="passwordInput" class="form-control" />
                                <label class="form-label">Парола</label>
                            </div>

                            <div class="form-outline mb-4">
                                <input type="password" id="facultynumInput" class="form-control" />
                                <label class="form-label">Факултетен номер</label>
                            </div>

                            <div class="form-outline mb-4">
                                <input type="password" id="phonenumInput" class="form-control" />
                                <label class="form-label">Телефонен номер</label>
                            </div>
            

                            <button type="submit" class="btn btn-primary btn-block">
                                Регистрация
                            </button>

                            <div class="form-outline mt-4">
                                <p>За регистриран потребител: <a href="#!" class="link-info"> Вход</a></p>
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
});
