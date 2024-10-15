import React from "react";
import styles from '../styles/saldo.module.css'
import Sidebar from "../components/sidebar";
import Header1 from "../components/header1";

function Saldo(){
    return(
        <div className={styles.container}>
            <Header1/>
            <div className={styles.resto}>
                <div className={styles.sb}>
                    <Sidebar/>
                </div>
                <div className={styles.main}>
                    <h1>Teste</h1>
                </div>
            </div>
        </div>
    )
}

export default Saldo;