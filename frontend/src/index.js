import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import Intro from './pages/intro';
import Login from './pages/login';
import Resetsenha from './pages/resetpwrd';
import Cadastro from './pages/cadastro';
import Saldo from './pages/saldo';

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
    path: "/Saldo",
    element: <Saldo />
  },
  {
    path: "/Caixinha",
    element: <Resetsenha />
  },
  {
    path: "/",
    element: <Resetsenha />
  },
])


root.render(
  <React.StrictMode>
      <RouterProvider router={router}/>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
