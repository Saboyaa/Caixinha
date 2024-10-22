import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import Intro from './pages/intro';
import Login from './pages/login';
import Resetsenha from './pages/resetpwrd';
import Cadastro from './pages/cadastro';  
import MainPage from './pages/main';
import { AppProvider } from './context/appContext';

const root = ReactDOM.createRoot(document.getElementById('root'));

const router = createBrowserRouter([
  {
    path: "/Login",
    element: <Login />
  },
  {
    path: "/",
    element: <Intro />
  },
  {
    path: "/Cadastro",
    element: <Cadastro/>
  },
  {
    path: "/Resetsenha",
    element: <Resetsenha />
  },
  {
    path: "/Main",
    element: <MainPage />
  },
  {
    path: "/Caixinha",
    element: <Resetsenha />
  },
])


root.render(

  <React.StrictMode>
      <AppProvider>
        <RouterProvider router={router}/>
      </AppProvider> 
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
