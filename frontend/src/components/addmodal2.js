import styles from '../styles/components/addmodal.module.css'
import React from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from '../context/AuthProvider';

function Addmodal2() {
    const [bancoSelecionado, setBancoSelecionado] = useState('');
    const [montante, setMontante] = useState('');
    const [id, setID] = useState('');
    const [erro, setErro] = useState(false);

    const { token } = useAuth();

    const navigate = useNavigate();

    const bancos = [
        "Banco do Brasil",
        "Caixa Econômica",
        "Bradesco",
        "Itaú",
        "Santander",
        "Nubank"
    ];

    const handleBancoChange = (event) => {
        setBancoSelecionado(event.target.value);
    };

    const handleSubmit = async (event) => {
      event.preventDefault();

      fetch("http://localhost:8080/accounts", {
        method: 'POST',
        headers: {
          Authorization: 'Bearer ' + token.token,
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          accountNumber: id,
          userId: token.userId,
          bankName: bancoSelecionado,
          accountBalance: montante
        })
      })
      .then((res) => {
        res.json();
      })
      .then((data) => {
        console.log(data);
      })
    };

    return(
      <div className={styles.Container}>
        <h2>Adicionar Entrada</h2>
         <div className={styles.forms}>
           <form onSubmit={handleSubmit}>
           <div className={styles.inputs}>  
              <input
                type="Valor em Reais"
                placeholder="Valor em Reais"
                id="Valor em Reais"
                value={montante}
                onChange={(e) => setMontante(e.target.value)}
              />
              <input
                type="text"
                placeholder="ID"
                id="Id"
                value={id}
                onChange={(e) => setID(e.target.value)}
              />
            </div>
            <select 
                  id="bancos" 
                  value={bancoSelecionado} 
                  onChange={handleBancoChange} 
                  required
              >
                  <option value="" disabled>Escolha um banco</option>
                  {bancos.map((banco, index) => (
                      <option key={index} value={banco}>
                          {banco}
                      </option>
                  ))}
            </select>
            {erro && (
              <div className={styles.erro}>
                <h4>Formulário não submetido. Preencha os campos vazios</h4>
              </div>
            )}
            <button type='submit' style ={{width: '50%'}}>Adicionar Entrada</button>
          </form>
        </div>
      </div>  
    );
}

export default Addmodal2;