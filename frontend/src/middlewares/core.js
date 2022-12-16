import axios from 'axios';
import { API_REQUEST, apiError, apiSuccess } from "../actions/api";

const user = JSON.parse(localStorage.getItem('user'));

if (user && user.accessToken) 
     axios.defaults.headers.common = {'Authorization': `Bearer ${user.accessToken}`}
  
export const apiMiddleware = ({ dispatch }) => next => action => {
    next(action);

    if (action.type === API_REQUEST) {
        const { url, method, data, } = action.meta;
        axios({
            method,
            url,
            data
        })
            .then(({ data }) => dispatch(apiSuccess({ url: url, response: data })))
            .catch(error => {
                console.error(error);
                dispatch(apiError({ error: error.response.data }));
            });
    }
};