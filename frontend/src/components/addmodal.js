import styles from '../styles/components/addmodal.module.css'

import React from "react";
import { useState, useEffect, useContext } from "react";
import { useAuth } from "../context/AuthProvider";
import { AppContext } from "../context/AppContext";

function Addmodal(){
    const [bancoSelecionado, setBancoSelecionado] = useState('');
    const [montante, setMontante] = useState('');
    const [erro, setErro] = useState(false);
    const [userAccounts, setUserAccounts] = useState([]);
    const { token } = useAuth();
    const { setM2 } = useContext(AppContext);
    
    useEffect(() => {
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
            console.log(data);
            setUserAccounts(data.map(item => `${item.accountNumber} - ${item.bankName}`));
        })
        .catch((err) => {
            console.log(err);
        })
    }, []);

    const handleBancoChange = (event) => {
        setBancoSelecionado(event.target.value);
    };

    const handleSubmit = async (event) => {
      event.preventDefault();

      fetch("http://localhost:8080/transactions", {
        method: 'POST',
        headers: {
          Authorization: 'Bearer ' + token.token,
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          userId: token.userId,
          accountNumber: bancoSelecionado.split(" ")[0],
          bankName: bancoSelecionado.split(" ")[2],
          type: "entrada",
          transactionValue: montante
        })
      })
      .then((res) => {
        if (res.status !== 200 && res.status !== 201) {
          throw new Error('Falha de requisição das transações!');
        }
        return res.json();
      })
      .then((data) => {
        setMontante('');
        setBancoSelecionado('');
        setM2(false);
      })
      .catch((err) => {
        setErro(true);
        setMontante('');
        setBancoSelecionado('');
      });
    };

    return(
      <div className={styles.Container}>
        <h2>Adicionar Entrada</h2>
        <div className={styles.forms}>
          <div className={styles.inputs}>
            <input
              type="Valor em Reais"
              placeholder="Valor em Reais"
              id="Valor em Reais"
              value={montante}
              onChange={(e) => setMontante(e.target.value)}
            />
          </div>
            <select 
              id="bancos" 
              value={bancoSelecionado} 
              onChange={handleBancoChange} 
              required
            >
              <option value="" disabled>Escolha um banco</option>
              {userAccounts.map((banco, index) => (
                  <option key={index} value={banco}>
                      {banco}
                  </option>
              ))}
            </select>
            {erro && (
              <div className={styles.erro}>
                <h4>Formulário não submetido</h4>
              </div>
            )}
            <button onClick={handleSubmit} style = {{width: '50%'}}>Adicionar Entrada</button>
        </div>
      </div>  
    );
};

export default Addmodal;