import React from 'react';
import { connect } from "react-redux";
import { Navigate, Route } from "react-router";

const AuthRoute = props => {
    const { isAuthUser, type } = props;
    if (type === "guest" && isAuthUser) return <Navigate to={"/home"} />;
    else if ((type === "private" && !isAuthUser) || type === 'index') return <Navigate to={"/login"} />;

    return <Route {...props} />;
};

const mapStateToProps = ({ isAuthUser }) => ({
    isAuthUser
});

export default connect(mapStateToProps)(AuthRoute);
