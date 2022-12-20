import { API_SUCCESS, API_ERROR } from "../actions/api";
import { LOGOUT } from '../actions/auth';

export default (
    state = {
        isAuthUser: !!localStorage.getItem("user"),
        user: JSON.parse(localStorage.getItem("user")) || {},
        error: null
    },
    action
) => {
    switch (action.type) {
        case API_SUCCESS:
            let apiURL = action.url.substring(action.url.lastIndexOf('/') + 1)
            switch (apiURL) {
                case "login":
                    {
                        localStorage.setItem("user", JSON.stringify(action.payload));
                        return { ...state, isAuthUser: true, user: action.payload };
                    }
                case "register":
                    {
                        alert(action.payload);
                        return { ...state, isAuthUser: false, user: {} };
                    }
            }
        case API_ERROR:
            alert("Възникна грешка! " + action.payload)
            console.error(action.payload)
            return { ...state, error: action.payload }
        case LOGOUT:
            localStorage.removeItem("user");
            return { ...state, isAuthUser: false, user: {} };
        default:
            return state;
    }
};
