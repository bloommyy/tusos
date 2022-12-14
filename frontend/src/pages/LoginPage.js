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

    function btnOnClick() {
        if (email === "" || password === "") {
            alert("Не сте въвели e-mail или парола.");
            return;
        }

        props.login({ email, password });
    }

    return (<div>
        <div>
            <section className="">
                <div className="px-4 py-5 px-md-5 text-center text-lg-start bg-light">
                    <div className="container">
                        <div className="row gx-lg-5 align-items-center">
                            <div className="col-lg-6 mb-4">
                                <h1 className="my-4 display-3 fw-bold ls-tight">
                                    <img src={logo} className="mx-auto d-block" width="50%" alt="tu-sofia logo" />
                                    <span className="text-primary">Студентски общежития и столове</span>
                                </h1>
                                <p className="text-secondary">
                                    Уеб портал към Технически университет - София за настаняване на настоящи студенти в общежития.
                                    Регистрационната форма се попълва с валидни данни за съответния студент.
                                </p>
                            </div>
                            <div className="col-lg-6 mb-5 mb-lg-0">
                                <div className="card">
                                    <div className="card-body py-5 px-md-5">
                                        <form>
                                            <div className="form-outline mb-4">
                                                <label className="form-label">Email</label>
                                                <input type="text" onChange={value => setEmail(value.target.value)} id="emailInput" className="form-control" />
                                            </div>
                                            <div className="form-outline mb-4">
                                                <label className="form-label">Парола</label>
                                                <input type="password" onChange={value => setPassword(value.target.value)} id="passwordInput" className="form-control" />
                                            </div>

                                            <button type="submit" onClick={btnOnClick} className="btn btn-primary btn-block">
                                                Вход
                                            </button>

                                            <div className="form-outline mt-4">

                                                {/*add link to registerPage.js in href property*/}
                                                <p>За нов потребител: <a href="#!" className="link-info"> Регистрация</a></p>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>)
});
