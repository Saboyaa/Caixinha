import styles from '../styles/components/estatísticas.module.css'
import React from 'react';
import Gráfico from '../components/gráfico';
import { useState, useEffect } from 'react';



const Estatísticas = () => {

    const gastosFake = [
        { valor: 800, motivo: 'Lazer' },
        { valor: 1200, motivo: 'Educação' },
        { valor: 350, motivo: 'Alimentação' },
        { valor: 600, motivo: 'Transporte' },
        { valor: 1500, motivo: 'Saúde' },
        { valor: 450, motivo: 'Vestuário' },
    ];

    const Gastos = []

    const gastosFiltrados = Gastos.filter(gasto => gasto.valor < 0)
    

    //Passar o gastos Filtrados na componente gráfico.


    return (
        <div className={styles.container}>
            <h2>Estatísticas</h2>
            <br></br>
            <Gráfico array={gastosFake}/>
        </div>
    );
}

export default Estatísticas;