import React, { useState } from 'react';
import { connect } from 'react-redux';
import { register } from '../actions/auth';
import logo from "../assets/logo-tu.png";

function Alert(props) {
    return //<MuiAlert elevation={6} variant="filled" {...props} />;
}

export default connect(({ error }) => ({ error }), { register })(props => {
    const [firstName, setFirstName] = useState("");
    const [middleName, setMiddlename] = useState("");
    const [lastName, setlastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [facultyNumber, setFacultyNumber] = useState("");
    const [phoneNumber, setPhoneNumber] = useState("");
    const [error, setError] = useState("");

    function btnOnClick(e) {
        e.preventDefault()

        if (email === "" || password === "") {
            alert("Не сте въвели e-mail или парола.");
            return;
        }

        props.register({ firstName, middleName, lastName, facultyNumber, email, password, phoneNumber });
    }

    return (<div>
        <section className="">
            <div className="px-4 py-5 px-md-5 text-center text-lg-start">
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
                                            <label className="form-label">Име</label>
                                            <input type="text" onChange={input => setFirstName(input.target.value)} id="nameInput" className="form-control" />
                                        </div>
                                        <div className="form-outline mb-4">
                                            <label className="form-label">Презиме</label>
                                            <input type="text" onChange={input => setMiddlename(input.target.value)} id="surnameInput" className="form-control" />
                                        </div>
                                        <div className="form-outline mb-4">
                                            <label className="form-label">Фамилия</label>
                                            <input type="text" onChange={input => setlastName(input.target.value)} id="lastnameInput" className="form-control" />
                                        </div>
                                        <div className="form-outline mb-4">
                                            <label className="form-label">Email</label>
                                            <input type="email" onChange={input => {
                                                setEmail(input.target.value)
                                                if (!input.target.value.match("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$"))
                                                    input.target.className = "form-control is-invalid"
                                                else
                                                    input.target.className = "form-control"
                                            }} id="emailInput" className="form-control" />
                                        </div>

                                        <div className="form-outline mb-4">
                                            <label className="form-label">Парола</label>
                                            <input type="password" onChange={input => setPassword(input.target.value)} id="passwordInput" className="form-control" />
                                        </div>

                                        <div className="form-outline mb-4">
                                            <label className="form-label">Повтори парола</label>
                                            <input type="password" onChange={input => { if (input.target.value !== password) { input.target.className = "form-control is-invalid" } else { input.target.className = "form-control" } }} id="repeatPasswordInput" className="form-control" />
                                        </div>

                                        <div className="form-outline mb-4">
                                            <label className="form-label">Факултетен номер</label>
                                            <input type="password" onChange={input => setFacultyNumber(input.target.value)} id="facultynumInput" className="form-control" />
                                        </div>

                                        <div className="form-outline mb-4">
                                            <label className="form-label">Телефонен номер</label>
                                            <input type="password" onChange={input => setPhoneNumber(input.target.value)} id="phonenumInput" className="form-control" />
                                        </div>

                                        <button type="submit" onClick={btnOnClick} className="btn btn-primary btn-block">
                                            Регистрация
                                        </button>

                                        <div className="form-outline mt-4">
                                            <p>За регистриран потребител: <a href="login" className="link-info"> Вход</a></p>
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
