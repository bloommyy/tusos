import React, { useState } from 'react';
import { connect } from 'react-redux';
import { forgottenPassword } from '../actions/auth';
import logo from "../assets/logo-tu.png";

export default connect(({ error }) => ({ error }), { forgottenPassword })(props => {
    const [email, setEmail] = useState("");

    function btnOnClick(e) {
        e.preventDefault()

        if (email === "") {
            alert("Не сте въвели e-mail.");
            return;
        }

        props.forgottenPassword({ email });
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
                                                <input type="email" onChange={input => {
                                                    setEmail(input.target.value)
                                                    if (!input.target.value.match("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$"))
                                                        input.target.className = "form-control is-invalid"
                                                    else
                                                        input.target.className = "form-control"
                                                }} id="emailInput" className="form-control" />
                                            </div>
                                            <button type="submit" onClick={btnOnClick} className="btn btn-primary btn-block">
                                                Изпращане на имейл
                                            </button>

                                            <div className="form-outline mt-4">

                                                <p><a href="login" className="link-info"> Вход</a></p>
                                            </div>
                                            <div className="form-outline mt-4">

                                                <p>За нов потребител: <a href="register" className="link-info"> Регистрация</a></p>
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
