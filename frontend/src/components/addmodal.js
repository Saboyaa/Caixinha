import styles from '../styles/components/addmodal.module.css'

import React from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Addmodal(){

    const [bancoSelecionado, setBancoSelecionado] = useState('');

    const bancos = [
        "Banco do Brasil",
        "Caixa Econômica",
        "Bradesco",
        "Itaú",
        "Santander",
        "Nubank"
    ];

    const[montante, setMontante] = useState('')

    const navigate = useNavigate();

    //erros
    const [erro1, setErro1] = useState(false);
    const [erro3, seterro3] = useState(false);

    const handleBancoChange = (event) => {
        setBancoSelecionado(event.target.value);
    };

    async function handleSubmit(e){
        e.preventDefault();
        setErro1(false);
        seterro3(false);


        if(montante === ''){
            setErro1(true);
        } else{

            try {
                
                console.log("teste")
            
            } 
            
            catch (e) {
                console.error("Erro: ", e);
            }

        }
         
    };

    return(
      <div className={styles.Container}>
        <h2>Adicionar Entrada</h2>
        <div className={styles.forms}>
          <div className={styles.inputs}>
            {/* <label htmlFor="Valor">Valor em Reais: </label> */}
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
                {bancos.map((banco, index) => (
                    <option key={index} value={banco}>
                        {banco}
                    </option>
                ))}
          </select>
          {erro1 && (
            <div className={styles.erro}>
              <h4>Formulário não submetido. Preencha os campos vazios</h4>
            </div>
          )}
          {erro3 && (
            <div className={styles.erro}>
              <h4>Formulário não submetido. As Nomes não coincidem!</h4>
            </div>
          )}
          <button onClick={handleSubmit} style = {{width: '50%'}}>Adicionar Entrada</button>
        </div>
      </div>  
      
    )
}

export default Addmodal;