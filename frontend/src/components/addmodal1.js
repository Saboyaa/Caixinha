import styles from '../styles/components/addmodal.module.css'
import React from "react";
import { useState } from "react";


function Addmodal1(){



    const[montante, setMontante] = useState('');
    const[objetivo, setObjetivo] = useState("");

    const [erro1, setErro1] = useState(false);
    const [erro3, seterro3] = useState(false);


    async function handleSubmit(e){
        e.preventDefault();
        setErro1(false);
        seterro3(false);


        if(montante === '' || objetivo === ''){
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
        <h2>Adicionar Caixinha</h2>
        <div className={styles.forms}>
          <div className={styles.inputs}>
            <input
              type="text"
              placeholder="Valor em Reais"
              id="Montante"
              value={montante}
              onChange={(e) => setMontante(e.target.value)}
            />
            <input
              type="text"
              placeholder="Objetivo"
              id="Objetivo"
              value={objetivo}
              onChange={(e) => setObjetivo(e.target.value)}
            />
          </div>
          {erro1 && (
            <div className={styles.erro}>
              <h4>Formulário não submetido. Preencha os campos vazios</h4>
            </div>
          )}
          {erro3 && (
            <div className={styles.erro}>
              <h4>Formulário não submetido. Os Nomes não coincidem!</h4>
            </div>
          )}
          <button onClick={handleSubmit} style = {{width: '50%'}}>Adicionar Caixinha</button>
        </div>
      </div>  
      
    )
}

export default Addmodal1;