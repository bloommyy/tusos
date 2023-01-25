export const LOGIN = "LOGIN";
export const LOGOUT = "LOGOUT";
export const REGISTER = "REGISTER";
export const FORGOTTEN_PASSWORD = "FORGOTTEN_PASSWORD";

export const login = user => {
    return {
        type: LOGIN,
        payload: user
    }
}

export const register = user => {
    return {
        type: REGISTER,
        payload: user
    }
}

export const logout = user => {
    return {
        type: LOGOUT,
        payload: user
    }
}

export const forgottenPassword = user => {
    return {
        type: FORGOTTEN_PASSWORD,
        payload: user
    }
}
