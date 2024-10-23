import styles from '../styles/components/cardTransação.module.css';
import { AiOutlinePlus } from 'react-icons/ai';
import { AiOutlineMinus } from 'react-icons/ai';
import { useState, useEffect } from 'react';

const Card = ({ transação }) => {
    
    const [icont, setIcont] = useState(1);

    const icons = [
        <AiOutlineMinus style={{ color: '#fb3333' }} />,
        <AiOutlinePlus style={{ color: '#4cd080' }} />
    ];

    // Use useEffect para alterar o estado com base na mudança de transação
    useEffect(() => {
        if (transação.valor < 0) {
            setIcont(0);
        } else {
            setIcont(1);
        }
    }, [transação.valor]); // Atualiza o ícone sempre que o valor da transação mudar


    let vl = Math.abs(transação.valor);
    return (
        <div className={styles.container}>
            <div className={styles.icon}>
                <div>{icons[icont]}</div>
            </div>
            <div className={styles.resto}>
                <div className={styles.text}>R${vl}</div>
                <div className={styles.logo}>{transação.banco}</div>
            </div>
        </div>
    );
};

export default Card;
