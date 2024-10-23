import styles from '../styles/components/estatísticas.module.css'
import React from 'react';
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from 'recharts';

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
            <div className={styles.grafico}>
                <BarChart width={800} height={400} data={gastos} margin={{ top: 5, right: 30, left: 30, bottom: 5 }}>
                    <CartesianGrid strokeDasharray="3 3" />
                    <XAxis dataKey="motivo" />
                    <YAxis />
                    <Tooltip />
                    {/* <Legend /> */}
                    <Bar dataKey="valor" fill="#4dd081" />
                </BarChart>
            </div>
        </div>
    );
}

export default Estatísticas;