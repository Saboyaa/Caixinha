import styles from '../styles/components/estatísticas.module.css'
import React from 'react';
import Gráfico from '../components/gráfico';
import { useState, useEffect } from 'react';



const Estatísticas = () => {
    const { transactions, setTransactions } = useState([]);

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
            setTransactions(data);
        })
        .catch((err) => {
            console.log(err);
        });
    }, []);

    const transactionsFiltered = transactions.filter(gasto => gasto.transactionValue < 0);
    let typesSums;
    transactionsFiltered.forEach(item => {
        if (typesSums[item.type]) {
            typesSums[item.type] += item.transactionValue;
        } else {
            typesSums[item.type] = item.transactionValue;
        }
    });

    return (
        <div className={styles.container}>
            <h2>Estatísticas</h2>
            <br></br>
            <Gráfico array={typesSums}/>
        </div>
    );
}

export default Estatísticas;