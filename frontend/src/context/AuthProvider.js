import React, { createContext, useState, useEffect, useMemo, useContext } from "react";

const AuthContext = createContext();

const AuthProvider = ({ children }) => {
    // const [token, setToken_] = useState(localStorage.getItem("token"));
    const [token, setToken_] = useState({});

    const setToken = (newToken) => {
        setToken_(newToken);
    };

    // useEffect(() => {
    //     if (token) {
    //         localStorage.setItem('token', token);
    //     } else {
    //         localStorage.removeItem('token');
    //     }
    // }, [token]);

    const contextValue = useMemo(() => ({
        token,
        setToken
    }), [token]);

    return (
        <AuthContext.Provider value={contextValue}>{children}</AuthContext.Provider>
    );
};

export const useAuth = () => {
    return useContext(AuthContext);
};

export default AuthProvider;