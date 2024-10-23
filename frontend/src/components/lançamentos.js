import styles from '../styles/components/lançamentos.module.css'
import { useState } from 'react';
import Addmodal from '../components/addmodal';
import Delmodal from '../components/delmodal';
import { AiOutlineClose } from "react-icons/ai";
import Card from '../components/cardTransação';

const Lançamentos = () => {
    const [modal1, setmodal1] = useState(false);
    const [modal2, setmodal2] = useState(false);

    const openModal1 = () =>{
        setmodal1(true);
    }
    const openModal2 = () =>{
        setmodal2(true);
    }

    const closeModal1 = () =>{
        setmodal1(false);
    }

    const closeModal2 = () =>{
        setmodal2(false);
    }
    
    const transações = [
        {
            valor: 1500,
            banco: 'Banco do Brasil'
        },
        {
            valor: -1200,
            banco: 'Caixa'
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
                {modal1 && (
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
    
                    {modal2 && (
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
                    {transações.map((transação, index) => (
                        <Card key={index} transação={transação}/>
                    ))}
                </div>
            </div>
        </div>
    )
}

export default Lançamentos;