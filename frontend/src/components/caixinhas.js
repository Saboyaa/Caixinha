import React, { useState } from 'react';
import styles from '../styles/components/caixinhas.module.css'
import Caixinhagrid from './caixinhagrid';
import Addmodal1 from './addmodal1';
import Delmodal1 from './delmodal1';
import { AiOutlineClose } from 'react-icons/ai';

const Caixinhas = () => {

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

    const initialData = [
        { nome: 'Viagem', valor: 1500 },
        { nome: 'Carro', valor: 20000 },
        { nome: 'Presente', valor: 300 },
        { nome: 'Educação', valor: 10000 },
        { nome: 'Investimento', valor: 5000 }
    ];

  return (
    <div className={styles.bigContainer}>
        <div className={styles.caixinhascontainer}>
            <h2>Separe dinheiro para objetivos pessoais</h2>
            <div className={styles.grid}>
                    <Caixinhagrid Array={initialData}/>
            </div>
        </div>
        <div className={styles.options}>
                <div className={styles.optionstext}>
                    <h2>Operações</h2>
                </div>
                <div className={styles.btns}>
                    <button className={styles.addbutton} onClick={openModal1} style={{marginRight: "30px"}}>Adicionar Caixinha</button>
                    <button className={styles.delbutton} onClick={openModal2}>Remover Caixinha</button>
                </div>
                {modal1 && (
                                <div className={styles.modaloverlay}>
                                    <div className={styles.modalcontent}>
                                        <div className={styles.closeoption}>
                                            <button className={styles.closebutton} onClick={closeModal1}>
                                                <AiOutlineClose  color="white" size={24} />
                                            </button>
                                        </div>
                                        <Addmodal1/>
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
                                        <Delmodal1/>
                                    </div>
                                </div>    
                    )}
        </div>
    </div>

  );
};

export default Caixinhas;
