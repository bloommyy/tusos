import axios from "axios";
import { SERVER_URL, GET, POST } from "../middlewares/app";

const user = JSON.parse(localStorage.getItem('user'));
if (user && user.accessToken)
    axios.defaults.headers.common = { 'Authorization': `Bearer ${user.accessToken}` }

function getRequest(url, body) {
    if (body === undefined)
        return axios.post(url).then((response) => response.data).catch((error) => console.error(error))

    return axios(
        {
            method: POST,
            url: url,
            headers: { 'Content-Type': 'application/json' },
            data: body
        }
    ).then((response) => { return response.data })
}

export function hasRoom() {
    let url = `${SERVER_URL}/student/hasRoom`
    return getRequest(url)
}

export function getAvailableDorms() {
    let url = `${SERVER_URL}/room/fetchAvailableDorms`
    return getRequest(url)
}

export function getAvailableRoomsForDorm(dormId) {
    let url = `${SERVER_URL}/room/fetchAvailableRoomsForDorm`
    return getRequest(url, { 'dormId': dormId })
}

export function addStudentToRoom(dormId, roomNumber) {
    let url = `${SERVER_URL}/room/addStudent`
    return getRequest(url, { 'dormId': dormId, 'roomNumber': roomNumber })
}