import styles from '../styles/components/saldo.module.css'
import { useState } from 'react';
import Card2 from './cardsaldo';
import Addmodal2 from './addmodal2';
import { AiOutlineClose } from 'react-icons/ai';

const Saldo = () => {

    const Bancos = [];

    const BancosFake = [{
        id: 101,
        nome: 'Nubank',
        saldo: 1500,
    },
    {
        id: 102,
        nome: 'Bradesco',
        saldo: 1300,
    },
    ]

    const [modal1, setmodal1] = useState(false);

    const openModal1 = () =>{
        setmodal1(true);
    }

    const closeModal1 = () =>{
        setmodal1(false);
    }

    return(
        <div className={styles.container}>
            <div className={styles.ola}>
                <h1>Olá, [nome]</h1>
            </div>
            <div className={styles.saldoTotal}>
                <h2  style={{ color: '#8F92A1', fontWeight:"normal"}}>Saldo Total Disponível:</h2>
                <h2>R$ [saldoTotal]</h2>
            </div>
            <div className={styles.meusSaldos}>
                <h1>Meus saldos</h1>
            </div>
            <div className={styles.bancos}>
                {BancosFake.map((banco, index) => (
                            <Card2 key={index} banco={banco}/>
                        ))}
                </div>
            <div className={styles.modal}>
                <button className={styles.btn} onClick={openModal1}><p>Adicionar um banco</p></button>
                {modal1 && (
                                <div className={styles.modaloverlay}>
                                    <div className={styles.modalcontent}>
                                        <div className={styles.closeoption}>
                                            <button className={styles.closebutton} onClick={closeModal1}>
                                                <AiOutlineClose  color="white" size={24} />
                                            </button>
                                        </div>
                                        <Addmodal2/>
                                    </div>
                                </div>
                )}
            </div>
        </div>
    )
}

export default Saldo;