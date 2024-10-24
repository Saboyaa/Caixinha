import React, { createContext, useState } from "react";

export const AppContext = createContext();

export const AppProvider = ({ children }) => {
    const [sb, setSb] = useState(1);
    
<<<<<<< HEAD:frontend/src/context/appContext.js

=======
>>>>>>> 4a612e97884be3d4293317440710fdebda3c008c:frontend/src/context/AppContext.js
    return (
        <AppContext.Provider value={{ sb, setSb }}>
            {children}
        </AppContext.Provider>
    );
};