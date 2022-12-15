import { apiRequest } from "../actions/api";
import { LOGIN, REGISTER } from "../actions/auth";

const SERVER_URL = `http://localhost:8080`;

export const appMiddleware = () => next => action => {
    next(action);
    switch (action.type) {
        case LOGIN: {
            next(
                apiRequest({
                    url: `${SERVER_URL}/login`,
                    method: "POST",
                    data: {
                        email: action.payload.email,
                        password: action.payload.password
                    }
                })
            )
            break;
        }
        case REGISTER: {
            next(
                apiRequest({
                    url: `${SERVER_URL}/student/register`,
                    method: "POST",
                    data: {
                        firstName: action.payload.firstName,
                        middleName: action.payload.middleName,
                        lastName: action.payload.lastName,
                        facultyNum: action.payload.facultyNumber,
                        email: action.payload.email,
                        password: action.payload.password,
                        phoneNumber: action.payload.phoneNumber,
                        role: ["ROLE_STUDENT"]
                    }
                })
            )
        }
        default:
            break;
    }
}