import styles from '../styles/components/addmodal.module.css'

import React from "react";
import { useState, useContext, useEffect } from "react";
import { useAuth } from '../context/AuthProvider';
import { AppContext } from '../context/AppContext';

function Delmodal(){
    const [bancoSelecionado, setBancoSelecionado] = useState('');
    const [tipoSelecionado, setTipoSelecionado] = useState('');
    const [montante, setMontante] = useState('');
    const [userAccounts, setUserAccounts] = useState([]);
    const [erro, setErro] = useState(false);
    const { token } = useAuth(); 
    const { setM3 } = useContext(AppContext);

    const tipos = [
      'saúde', 
      'vestuário',
      'educação',
      'lazer',
      'restaurantes',
      'gastos fixos'
    ];

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
          type: tipoSelecionado,
          transactionValue: -1*montante
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
        setTipoSelecionado('');
        setM3(false);
      })
      .catch((err) => {
        setErro(true);
        setMontante('');
        setBancoSelecionado('');
        setTipoSelecionado('');
      });
    };

    const handleBancoChange = (event) => {
        setBancoSelecionado(event.target.value);
    };

    const handleTipoChange = (event) => {
      setTipoSelecionado(event.target.value);
    };

    return(
      <div className={styles.Container}>
        <h2 style={{color: '#fb3333'}}>Adicionar Saída</h2>
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
                id="tipos" 
                value={tipoSelecionado} 
                onChange={handleTipoChange} 
                required
            >
                <option value="" disabled>Classifique o gasto</option>
                {tipos.map((tipo, index) => (
                    <option key={index} value={tipo}>
                        {tipo}
                    </option>
                ))}
          </select>
          <select 
                id="tipo" 
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
          <button style={{backgroundColor: "#fb3333", width: '50%'}} onClick={handleSubmit}>Adicionar Saída</button>
        </div>
      </div>  
      
    )
}

export default Delmodal;