import styles from '../styles/login.module.css'
import React from 'react';
import Header1 from '../components/header1';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Cadastro(){
    const [nome, setNome] = useState("");
    const [email, setemail] = useState("");
    const [password, setPassword] = useState("");
    const [password2, setPassword2] = useState("");
    const [error, setError] = useState("");

    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (password !== password2) {
            setError("Senhas diferentes");
            setPassword2("");
            navigate("/Cadastro");
            return;
        }
        fetch('http://localhost:8080/auth/signup', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                name: nome,
                email: email,
                password: password
            })
        })
        .then((res) => {
            if(res.status === 422) {
                throw new Error("A validação falhou!");
            }
            if (res.status !== 200 && res.status !== 201) {
                throw new Error("A criação de usuário falhou");
            }
            navigate("/Login");
        })
        .catch((err) => {
            setError(err.message);
            setNome("");
            setemail("");
            setPassword("");
            setPassword2("");
            navigate("/Cadastro");
        });
    };

    return (
        <div className={styles.container}>
            <Header1/>
            <div className={styles.log}>
                <div className={styles.box}>
                    <h2>Cadastro</h2>
                    <form onSubmit={handleSubmit} className={styles.forms}>
                        <div className={styles.inputs}>
                            <label htmlFor="Nome">Nome: </label>
                            <input
                            type="text"
                            placeholder="Nome"
                            id="nome"
                            value={nome}
                            onChange={(e) => setNome(e.target.value)}/>
                        </div>
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
                        <div className={styles.inputs}>
                            <label htmlFor="Senha2">Repita a senha: </label>
                            <input
                            type="password"
                            placeholder="Repita a senha"
                            id="Password"
                            value={password2}
                            onChange={(e) => setPassword2(e.target.value)}/>
                        </div>
                        {error && (
                            <div className={styles.erro}>
                                <h4>{error}</h4>
                            </div>
                        )}
                        <button type="submit">Cadastro</button>
                    </form>
                </div>
            </div>
        </div>
      );
}

export default Cadastro;