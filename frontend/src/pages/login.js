import styles from '../styles/login.module.css'
import React from 'react';
import Header1 from '../components/header1';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';
import { useAuth } from '../context/AuthProvider';

function Login() {
    const { setToken } = useAuth();

    const [email, setemail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");

    const navigate = useNavigate();

    const handleSubmit = async(e) => {
        e.preventDefault();

        fetch('http://localhost:8080/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                email: email,
                password: password
            })
        })
        .then((res) => {
            if(res.status === 422) {
                throw new Error("A validação falhou!");
            }
            if (res.status !== 200 && res.status !== 201) {
                throw new Error("Falha na autenticação!");
            }
            return res.json();
        })
        .then((res) => {
            setToken({
                token: res.token,
                userId: res.id,
                name: res.name,
                email: res.email
            });
            navigate("/main", { replace: true });
        })
        .catch((err) => {
            setError(err.message);
            setemail("");
            setPassword("");
            navigate("/login", { replace: true });
        });
    };

    return (
        <div className={styles.container}>
            <Header1/>
            <div className={styles.log}>
                <div className={styles.box}>
                    <h2>Login</h2>
                    <form onSubmit={handleSubmit} className={styles.forms}>
                        <div className={styles.inputs}>
                            <label htmlFor="Email">Email: </label>
                            <input
                            type="text"
                            placeholder="Email"
                            id="email"
                            value={email}
                            onChange={(e) => setemail(e.target.value)}/>
                        </div>
                        <div className={styles.inputs}>
                            <label htmlFor="Senha">Senha: </label>
                            <input
                            type="password"
                            placeholder="Senha"
                            id="Password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}/>
                        </div>
                        {error && (
                            <div className={styles.erro}>
                                <h4>{error}</h4>
                            </div>
                        )}
                        <button type="submit">Login</button>
                        {/* <Link to='/Resetsenha' style={{textDecoration: 'none', color: "#4cd080", fontWeight: "bold"}}>Esqueceu sua senha?</Link> */}
                    </form>
                </div>
            </div>
        </div>
      );
}

export default Login;