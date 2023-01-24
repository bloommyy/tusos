import { apiRequest } from "../actions/api";
import { LOGIN, REGISTER } from "../actions/auth";
import { ADD_FURNITURE, VIEW_FURNITURE, ADD_APPLIANCE, ADD_ALL_DORM_ROOMS } from "../actions/customAPI";

export const SERVER_URL = `http://localhost:8080`;
export const GET = 'GET';
export const POST = 'POST';

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
                    method: POST,
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
            break;
        }
        case ADD_FURNITURE: {
            next(
                apiRequest({
                    url: `${SERVER_URL}/room/addFurniture`,
                    method: POST,
                    data: {
                        furnitureName: action.payload.furnitureName,
                        isBroken: action.payload.isBroken
                    }
                })
            )
            break;
        }
        case ADD_APPLIANCE: {
            next(
                apiRequest({
                    url: `${SERVER_URL}/room/addElectricAppliance`,
                    method: POST,
                    data: {
                        applianceName: action.payload.applianceName,
                    }
                })
            )
            break;
        }
        case VIEW_FURNITURE: {
            next(
                apiRequest({
                    url: `${SERVER_URL}/room/getAllFurniture`,
                    method: GET,
                    data: {}
                })
            )
            break;
        }
        case ADD_ALL_DORM_ROOMS: {
            next(
                apiRequest({
                    url: `${SERVER_URL}/room/addAllDormRooms`,
                    method: POST,
                    data: {
                        dormId: action.payload.dormId,
                        floorCount: action.payload.floorCount,
                        roomsPerFloorCount: action.payload.roomsPerFloorCount
                    }
                })
            )
            break;
        }
        default:
            break;
    }
}