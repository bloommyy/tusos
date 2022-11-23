import axios from 'axios';
import { API_REQUEST, apiError, apiSuccess } from "../actions/api";

export const apiMiddleware = ({ dispatch }) => next => action => {
    next(action);

    if (action.type === API_REQUEST) {
        const { url, method, data } = action.meta;
        axios({
            method,
            url,
            data
        })
            .then(({ data }) => dispatch(apiSuccess({ response: data })))
            .catch(error => {
                console.error(error);
                dispatch(apiError({ error: error.response.data }));
            });
    }
};