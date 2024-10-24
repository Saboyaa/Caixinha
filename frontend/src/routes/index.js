import { RouterProvider, createBrowserRouter } from "react-router-dom";
import { useAuth } from "../context/AuthProvider";
import { ProtectedRoute } from "./ProtectedRoute";
import Intro from "../pages/intro";
import Cadastro from "../pages/cadastro";
import MainPage from "../pages/main";
import Login from "../pages/login";

const Routes = () => {
    const { token } = useAuth();

    const routesForPublic = [
        {
            path: "/",
            element: <Intro />
        }
    ];

    const routesForAuthenticatedOnly = [
        {
            path: "/",
            element: <ProtectedRoute />,
            children: [
                {
                    path: "/main",
                    element: <MainPage />
                }
            ]
        }
    ];

    const routesForNotAuthenticatedOnly = [
        {
            path: "/cadastro",
            element: <Cadastro />
        },
        {
            path: "/login",
            element: <Login />
        }
    ];

    const router = createBrowserRouter([
        ...routesForPublic,
        ...(!token ? routesForNotAuthenticatedOnly : []),
        ...routesForAuthenticatedOnly
    ]);

    return <RouterProvider router={router} />;
};
export default Routes;