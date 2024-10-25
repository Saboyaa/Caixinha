import styles from '../styles/intro.module.css'
import { useNavigate } from "react-router-dom";
import React from 'react';

function Intro(){

    const navigate = useNavigate();

    const redirecionar1 = (e) =>{
        e.preventDefault();
        navigate('/login');
    }

    const redirecionar2 = (e) =>{
        e.preventDefault();
        navigate('/cadastro');
    }

    return (
    <div className={styles.container}>
        <div className={styles.intro}>
            <div className={styles.logo}>
                <div className={styles.box}>Caixinha</div>
            </div>
            <p className={styles.subtitle}>Organize hoje, conquiste amanhã: o poder do controle financeiro em suas mãos!</p>
            <div className={styles.buttons}>
                <button className={styles.btn} onClick={redirecionar1}>ENTRE NA SUA CONTA</button>
                <button className={styles.btn} onClick={redirecionar2}>CRIE UMA CONTA</button>
            </div>
        </div>
    </div>
      );
}

export default Intro;