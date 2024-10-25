import styles from '../styles/components/estatísticas.module.css'
import React from 'react';
import Gráfico from '../components/gráfico';
import { useState, useEffect } from 'react';
import { useAuth } from '../context/AuthProvider';

const Estatísticas = () => {
    const [transactions, setTransactions] = useState([]);
    const { token } = useAuth();

    useEffect(() => {
        fetch('http://localhost:8080/transactions/userId/' + token.userId, {
            method: 'GET',
            headers: {
                Authorization: 'Bearer ' + token.token
            }
        })
        .then((res) => {
            if (res.status !== 200) {
                throw new Error('Falha de requisição das transações!');
            }
            return res.json();
        })
        .then((data) => {
            const transactionsFiltered = data.filter(gasto => gasto.transactionValue < 0).map(item => new Object({valor: -1*item.transactionValue, motivo: item.type}));
            setTransactions(transactionsFiltered);
        })
        .catch((err) => {
            console.log(err);
        });
    }, []);

    return (
        <div className={styles.container}>
            <h2>Estatísticas</h2>
            <br></br>
            <Gráfico array={transactions}/>
        </div>
    );
}

export default Estatísticas;