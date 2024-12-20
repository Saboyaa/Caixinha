import styles from '../styles/components/saldo.module.css'
import { useEffect, useState } from 'react';
import Card2 from './cardsaldo';
import Addmodal2 from './addmodal2';
import { AiOutlineClose } from 'react-icons/ai';
import { useAuth } from '../context/AuthProvider';
import { useContext } from 'react';
import { AppContext } from '../context/AppContext';


const Saldo = () => {

    const { m1, setM1 } = useContext(AppContext);
    const { token } = useAuth();
    const [accounts, setAccounts] = useState([]);
    const [saldoTotal, setSaldoTotal] = useState(0);

    const fetchData = () => {
        fetch('http://localhost:8080/accounts/userId/' + token.userId, {
            method: 'GET',
            headers: {
                Authorization: 'Bearer ' + token.token
            }
        })
        .then((res) => {
            if (res.status !== 200) {
                throw new Error('Falha de requisição das contas!');
            }
            return res.json();
        })
        .then((data) => {
            let sum = 0;
            data.forEach(account => {
                sum += account.accountBalance;
            });
            setSaldoTotal(sum);
            setAccounts(data);
        })
        .catch((err) => {
            console.log(err);
        })
    };

    useEffect(() => {
        fetchData();

        const intervalId = setInterval(() => {
            fetchData();
        }, 300);
      
        return () => clearInterval(intervalId);
    }, []);

    const openModal1 = () =>{
        setM1(true);
    }

    const closeModal1 = () =>{
        setM1(false);
    }

    return(
        <div className={styles.container}>
            <div className={styles.ola}>
                <h1>Olá, {token.name}</h1>
            </div>
            <div className={styles.saldoTotal}>
                <h2  style={{ color: '#8F92A1', fontWeight:"normal"}}>Saldo Total Disponível:</h2>
                <h2>R$ {saldoTotal}</h2>
            </div>
            <div className={styles.meusSaldos}>
                <h1>Meus saldos</h1>
            </div>
            <div className={styles.bancos}>
                {accounts.map((banco, index) => (
                            <Card2 key={index} banco={banco}/>
                        ))}
            </div>
            <div className={styles.modal}>
                <button className={styles.btn} onClick={openModal1}><p>Adicionar um banco</p></button>
                {m1 && (
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