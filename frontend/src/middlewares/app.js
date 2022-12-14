import { apiRequest } from "../actions/api";
import { LOGIN } from "../actions/auth";

const SERVER_URL = `http://localhost:8080`;

export const appMiddleware = () => next => action => {
    next(action);
    switch (action.type) {
        case LOGIN: {
            next(
                apiRequest({
                    url: `${SERVER_URL}/student/login`,
                    method: "POST",
                    data: {
                        email: action.payload.email,
                        password: action.payload.password
                    }
                })
            )
            break;
        }
        default:
            break;
    }
}