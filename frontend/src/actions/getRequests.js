import axios from "axios";
import { SERVER_URL, GET } from "../middlewares/app";

const user = JSON.parse(localStorage.getItem('user'));
if (user && user.accessToken)
    axios.defaults.headers.common = { 'Authorization': `Bearer ${user.accessToken}` }

export function hasRoom() {
    let url = `${SERVER_URL}/student/hasRoom`
    return getRequest(url)
}

export function getAllRooms() {
    let url = `${SERVER_URL}/room/fetchAllRooms`
    return getRequest(url)
}

function getRequest(url) {
    return axios.get(url).then((response) => response.data).catch((error) => console.error(error))
}