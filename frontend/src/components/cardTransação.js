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

const Card = ({ transação }) => {
    const [icont, setIcont] = useState(1);
    const [logot, setLogot] = useState(1);

    const icons = [
        <AiOutlineMinus style={{ color: '#fb3333' }} />,
        <AiOutlinePlus style={{ color: '#4cd080' }} />
    ];
    const color = ['#fb3333', '#4cd080']

    useEffect(() => {
        if (transação.valor < 0) {
            setIcont(0);
        } else {
            setIcont(1);
        }
    }, [transação.valor]);
    
    useEffect(() => {
        if (transação.banco === 'Bradesco') {
            setLogot(0);
        } 
        if (transação.banco === 'Itau') {
            setLogot(1);
        } 
        if (transação.banco === 'Banco do Brasil') {
            setLogot(2);
        } 
        if (transação.banco === 'Nubank') {
            setLogot(3);
        } 
        if (transação.banco === 'Picpay') {
            setLogot(4);
        } 
    }, [transação.banco]);


    const logos = [Bradesco, Itau, BancodoBrasil, Nubank, Picpay];
    
    let vl = Math.abs(transação.valor);

    return (
        <div className={styles.container}>
            <div className={styles.resto}>
                <div style={{marginRight: '25px'}}><Logo image={logos[logot]}/></div>
                <div style={{marginTop:'10px'}}>{icons[icont]}</div>
                <div className={styles.text} style={{color: color[icont]}}>R${vl}</div>
            </div>
        </div>
    );
};

export default Card;
