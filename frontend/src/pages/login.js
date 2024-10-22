import styles from '../styles/login.module.css'
import React from 'react';
import Header1 from '../components/header1';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';

function Login(){
    const [email, setemail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");

    const navigate = useNavigate();

    const handleSubmit = async(e) => {
        e.preventDefault();


        setemail("");
        setPassword("");
        navigate('/Main')

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
                            <label htmlFor="Email">Senha: </label>
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
                        <Link to='/Resetsenha' style={{textDecoration: 'none', color: "#4cd080", fontWeight: "bold"}}>Esqueceu sua senha?</Link>
                    </form>
                </div>
            </div>
        </div>
      );
}

export default Login;