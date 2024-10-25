import styles from '../styles/components/cardTransação.module.css';
import { AiOutlinePlus } from 'react-icons/ai';
import { AiOutlineMinus } from 'react-icons/ai';
import { useState, useEffect } from 'react';
import Logo from './logo';
import Bradesco from '../imgs/bradescologo.png'
import Itau from '../imgs/itaulogo.png'
import BancodoBrasil from '../imgs/bancodobrasillogo.png'
import Nubank from '../imgs/nubanklogo.png'
import Picpay from '../imgs/picpaylogo.png'
import Santander from '../imgs/santanderlogo.png'
import Caixa from '../imgs/caixalogo.png'

const Card = ({ transação }) => {
    const [icont, setIcont] = useState(1);
    const [logot, setLogot] = useState(1);

    const icons = [
        <AiOutlineMinus style={{ color: '#fb3333' }} />,
        <AiOutlinePlus style={{ color: '#4cd080' }} />
    ];
    const color = ['#fb3333', '#4cd080']

    useEffect(() => {
        if (transação.transactionValue < 0) {
            setIcont(0);
        } else {
            setIcont(1);
        }
    }, [transação.transactionValue]);
    
    useEffect(() => {
        if (transação.bankName === 'Bradesco') {
            setLogot(0);
        } 
        if (transação.bankName === 'Itau') {
            setLogot(1);
        } 
        if (transação.bankName === 'Banco do Brasil') {
            setLogot(2);
        } 
        if (transação.bankName === 'Nubank') {
            setLogot(3);
        } 
        if (transação.bankName === 'Picpay') {
            setLogot(4);
        } 
        if (transação.bankName === 'Caixa') {
            setLogot(5);
        }
        if (transação.bankName === 'Santander') {
            setLogot(6);
        }  
    }, []);

    const logos = [Bradesco, Itau, BancodoBrasil, Nubank, Picpay, Caixa, Santander];
    
    let vl = Math.abs(transação.transactionValue);

    return (
        <div className={styles.container}>
            <div className={styles.resto}>
                <div className={styles.Content1}>
                    <div>{transação.accountNumber}</div>
                    <div style={{marginRight: '25px', marginLeft: '15px'}}><Logo image={logos[logot]}/></div>
                </div>
                <div className={styles.Content2}>
                    <div style={{marginTop:'10px', marginLeft: '20px', marginRight: '10px'}}>{icons[icont]}</div>
                    <div className={styles.text} style={{color: color[icont]}}>R${vl}</div>
                </div>  
            </div>
        </div>
    );
};

export default Card;
