import React, { createContext, useState } from "react";

export const AppContext = createContext();

export const AppProvider = ({ children }) => {
    const [sb, setSb] = useState(1);
    const [m1, setM1] = useState(false);
    const [m2, setM2] = useState(false);
    const [m3, setM3] = useState(false);
    const [m4, setM4] = useState(false);
    const [m5, setM5] = useState(false);
    const [m6, setM6] = useState(false);
    

    return (
        <AppContext.Provider value={{ sb, setSb, m1, setM1, m2, setM2, m3, setM3, m4, setM4, m5, setM5, m6, setM6 }}>
            {children}
        </AppContext.Provider>
    );
};
