import styles from '../styles/components/delmodal.module.css'
import React from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom"


function Delmodal(){

    const[ID, setID] = useState(1);
    const[nome, setNome] = useState("");
    const[categoria, setCategoria] = useState(" ");
    const[quantidade, setQuantidade] = useState(0);
    const[tamanho, setTamanho] = useState(" ");


    const navigate = useNavigate();

    //erros
    const [erro1, setErro1] = useState(false);
    const [erro2, setErro2] = useState(false);
    const [erro3, seterro3] = useState(false);

    async function handleSubmit(e){
        e.preventDefault();
        setErro1(false);
        seterro3(false);


        if(ID <= 999 || ID > 9999){
            setID(0);
            setErro1(true);
        } else{


            

            setID(0);

        }
         
    };

    return(
        <div className={styles.Container}>
            <h2>Remover item</h2>
            <div className={styles.forms}>
                <div className={styles.inputs}>
                    <label htmlFor="ID">Insira o identificador: </label>
                    <input
                    type="ID"
                    placeholder="ID"
                    id="ID"
                    value={ID}
                    onChange={(e) => setID(e.target.value)}/>
                </div>
                {erro1 && (
                    <div className={styles.erro}>
                        <h4>ID não válido!</h4>
                    </div>
                )}
                {erro3 && (
                    <div className={styles.erro}>
                        <h4>Formulário não submetido. As Nomes não coincidem!</h4>
                    </div>
                )}
                <button onClick={handleSubmit}>Remover item</button>
            </div>
        </div>
    )
}

export default Delmodal;