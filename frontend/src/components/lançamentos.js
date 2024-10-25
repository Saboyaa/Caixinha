import styles from '../styles/components/lançamentos.module.css'
import { useState, useContext } from 'react';
import Addmodal from '../components/addmodal';
import Delmodal from '../components/delmodal';
import { AiOutlineClose } from "react-icons/ai";
import Card from '../components/cardTransação';
import { AppContext } from '../context/AppContext';

const Lançamentos = () => {
    const { m2, setM2, m3, setM3 } = useContext(AppContext);

    const openModal1 = () =>{
        setM2(true);
    }
    const openModal2 = () =>{
        setM3(true);
    }

    const closeModal1 = () =>{
        setM2(false);
    }

    const closeModal2 = () =>{
        setM3(false);
    }

    const transaçõesFake = [
        {
            valor: 1500,
            banco: 'Banco do Brasil'
        },
        {
            valor: -1200,
            banco: 'Nubank'
        },
        {
            valor: 1800,
            banco: 'Bradesco'
        },
        {
            valor: 1800,
            banco: 'Bradesco'
        },
    ]

    return(
        <div className={styles.container}>
            <div className={styles.options}>
                <div className={styles.optionstext}>
                    <h2>Operações</h2>
                </div>
                <div className={styles.btns}>
                    <button className={styles.addbutton} onClick={openModal1} style={{marginRight: "30px"}}>Adicionar Entrada</button>
                    <button className={styles.delbutton} onClick={openModal2}>Adicionar Saida</button>
                </div>
                {m2 && (
                    <div className={styles.modaloverlay}>
                        <div className={styles.modalcontent}>
                            <div className={styles.closeoption}>
                                <button className={styles.closebutton} onClick={closeModal1}>
                                    <AiOutlineClose  color="white" size={24} />
                                </button>
                            </div>
                            <Addmodal/>
                        </div>
                    </div>
                )}
                {m3 && (
                    <div className={styles.modaloverlay}>
                        <div className={styles.modalcontent2}>
                            <div className={styles.closeoption}>
                                <button className={styles.closebutton} onClick={closeModal2}>
                                    <AiOutlineClose  color="white" size={24} />
                                </button>
                            </div>
                            <Delmodal/>
                        </div>
                    </div>    
                )}
            </div>
            <div className={styles.histórico}>
                <h1>Histórico</h1>
                <div className={styles.transações}>
                    {transaçõesFake.map((transação, index) => (
                        <Card key={index} transação={transação}/>
                    ))}
                </div>
            </div>
        </div>
    )
}

export default Lançamentos;