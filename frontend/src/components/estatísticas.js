import styles from '../styles/components/estatísticas.module.css'
import React from 'react';
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from 'recharts';
import Gráfico from '../components/gráfico';

const gastos = [
    { valor: 800, motivo: 'Lazer' },
    { valor: 1200, motivo: 'Educação' },
    { valor: 350, motivo: 'Alimentação' },
    { valor: 600, motivo: 'Transporte' },
    { valor: 1500, motivo: 'Saúde' },
    { valor: 450, motivo: 'Vestuário' },
];

const Estatísticas = () => {
    return (
        <div className={styles.container}>
            <h2>Estatísticas</h2>
            <br></br>
            <Gráfico array={gastos}/>
        </div>
    );
}

export default Estatísticas;