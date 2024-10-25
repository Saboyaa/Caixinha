import React from "react";
import styles from '../styles/main.module.css'
import Sidebar from "../components/sidebar";
import { useContext } from "react";
import { AppContext } from "../context/AppContext";
import Saldo from '../components/saldo'
import Caixinhas from "../components/caixinhas";
import Lançamentos from '../components/lançamentos'
import Estatísticas from "../components/estatísticas";
import Header2 from "../components/header2";
import Perfil from "../components/perfil";


function MainPage(){
    const { sb, setSb } = useContext(AppContext);

    const componentArray = [<Saldo/>, <Caixinhas/>, <Lançamentos/>, <Estatísticas/>, <Perfil/>]

    return(
        <div className={styles.container}>
            <Header2/>
            <div className={styles.resto}>
                <Sidebar/>
                <div className={styles.mainContent}>
                    <h1>{componentArray[sb - 1]}</h1>
                </div>
            </div>
        </div>
    )
}

export default MainPage;