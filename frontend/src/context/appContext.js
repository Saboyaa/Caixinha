import React, { createContext, useState } from "react";

export const AppContext = createContext();

export const AppProvider = ({ children }) => {
    const [sb, setSb] = useState(1);

    return (
        <AppContext.Provider value={{ sb, setSb }}>
            {children}
        </AppContext.Provider>
    );
};
