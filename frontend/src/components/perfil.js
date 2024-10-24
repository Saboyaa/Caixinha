import styles from '../styles/components/perfil.module.css'
import { useEffect, useState } from 'react';
import { useAuth } from '../context/AuthProvider';

const Perfil = () => {
    const { name, setName } = useState(localStorage.getItem('name'));
    const { email, setEmail } = useState(localStorage.getItem('email'));
    const { token } = useAuth();

    const usuario = {
        nome: "João Vitor Neves Duarte",
        email: "joao@example.com",
        aniversario: "10/10/1995",
        bancos: ["Banco do Brasil", "Caixa Econômica", "Nubank"]
    };

    return (
        <div className={styles.perfilcontainer}>
            <h2>Perfil do Usuário</h2>
            <div className={styles.perfilinfo}>
                <p><strong>Nome:</strong> {token}</p>
                <p><strong>Email:</strong> {usuario.email}</p>
                <div className={styles.perfilbancos}>
                    <h3>Bancos Cadastrados:</h3>
                    <ul>
                        {usuario.bancos.map((banco, index) => (
                            <li key={index}>{banco}</li>
                        ))}
                    </ul>
                </div>
            </div>
        </div>
    );
};

export default Perfil;