import styles from '../styles/login.module.css'
import React from 'react';
import Header1 from '../components/header1';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Resetsenha(){
    const [email, setemail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");

    const navigate = useNavigate();

    const handleSubmit = async(e) => {
        e.preventDefault();


        setemail("");
        setPassword("");
        navigate('/')

    };

    return (
        <div className={styles.container}>
            <Header1/>
            <div className={styles.log}>
                <div className={styles.box}>
                    <h2>Redefinir Senha</h2>
                    <form onSubmit={handleSubmit} className={styles.forms}>
                        <div className={styles.inputs}>
                            <label htmlFor="Email">Insira seu email: </label>
                            <input
                            type="text"
                            placeholder="Email"
                            id="email"
                            value={email}
                            onChange={(e) => setemail(e.target.value)}/>
                        </div>
                        {error && (
                            <div className={styles.erro}>
                                <h4>{error}</h4>
                            </div>
                        )}
                        <button type="submit">Enviar email</button>
                    </form>
                </div>
            </div>
        </div>
      );
}

export default Resetsenha;