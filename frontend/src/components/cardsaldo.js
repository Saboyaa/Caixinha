import styles from '../styles/components/cardsaldo.module.css'
import Bradesco from '../imgs/bradescologo.png'
import Itau from '../imgs/itaulogo.png'
import BancodoBrasil from '../imgs/bancodobrasillogo.png'
import Nubank from '../imgs/nubanklogo.png'
import Picpay from '../imgs/picpaylogo.png'
import { useState } from 'react'
import { useEffect } from 'react'
import Logo from './logo'

const Card2 = ({banco}) =>{

    const [logot, setLogot] = useState(1);

    const logos = [Bradesco, Itau, BancodoBrasil, Nubank, Picpay];

    useEffect(() => {
        if (banco.bankName === 'Bradesco') {
            setLogot(0);
        } 
        if (banco.bankName === 'Itau') {
            setLogot(1);
        } 
        if (banco.bankName === 'Banco do Brasil') {
            setLogot(2);
        } 
        if (banco.bankName === 'Nubank') {
            setLogot(3);
        } 
        if (banco.bankName=== 'Picpay') {
            setLogot(4);
        } 
    }, []);

    return(
        <div className={styles.banco}>
            <div className={styles.romero2}>
                <h3 className = {styles.img}><Logo image={logos[logot]}/></h3>
                <h3 className = {styles.nome}>{banco.accountNumber}</h3>
                <h3 className = {styles.nome}>{banco.bankName}</h3>
            </div>
            <h3 className = {styles.saldo}>R${banco.accountBalance}</h3>
        </div>
    )
}

export default Card2;