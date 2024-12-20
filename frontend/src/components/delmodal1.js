import styles from '../styles/components/addmodal.module.css'

import React from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Delmodal1(){

    const [bancoSelecionado, setBancoSelecionado] = useState('');
    const [tipoSelecionado, setTipoSelecionado] = useState('');
    const[objetivo, setObjetivo] = useState("");

    const tipos = [
      'saúde', 
      'vestuário',
      'educação',
      'lazer',
      'Restaurantes',
      'gastos fixos'
    ]

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

    const handleTipoChange = (event) => {
      setTipoSelecionado(event.target.value);
  };


    async function handleSubmit(e){
        e.preventDefault();
        setErro1(false);
        seterro3(false);


        if(montante === ''){
            setErro1(true);
        } else{

            try {
                // Cria/atualiza um documento com um ID específico
                console.log("teste")
            
            } 
            
            catch (e) {
                console.error("Erro: ", e);
            }

        }
         
    };

    return(
      <div className={styles.Container}>
        <h2 style={{color: '#fb3333'}}>Remover caixinha</h2>
        <div className={styles.forms}>
          <div className={styles.inputs}>
            {/* <label htmlFor="Valor">Valor em Reais: </label> */}
            <input
              type="text"
              placeholder="Objetivo"
              id="Objetivo"
              value={objetivo}
              onChange={(e) => setObjetivo(e.target.value)}
            />
          </div>

          <select 
                id="tipo" 
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
          <button style={{backgroundColor: "#fb3333", width: '50%'}} onClick={handleSubmit}>Remover caixinha</button>
        </div>
      </div>  
      
    )
}

export default Delmodal1;