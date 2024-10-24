import styles from '../styles/components/estatísticas.module.css'
import React from 'react';
import Gráfico from '../components/gráfico';
import { useState, useEffect } from 'react';

const gastos = [
    { valor: 800, motivo: 'Lazer' },
    { valor: 1200, motivo: 'Educação' },
    { valor: 350, motivo: 'Alimentação' },
    { valor: 600, motivo: 'Transporte' },
    { valor: 1500, motivo: 'Saúde' },
    { valor: 450, motivo: 'Vestuário' },
];

const Estatísticas = () => {

    const [data, setData] = useState(null);

    useEffect(() => {
        fetch('https://api.example.com/data')
        .then(response => response.json())
        .then(json => setData(json))
        .catch(error => console.error(error));
    }, []);


    return (
        <div className={styles.container}>
            <h2>Estatísticas</h2>
            <br></br>
            <Gráfico array={gastos}/>
        </div>
    );
}

export default Estatísticas;