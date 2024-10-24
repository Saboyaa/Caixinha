import styles from '../styles/components/perfil.module.css'

const Perfil = () => {
    const usuario = {
        nome: "João Vitor Neves Duarte",
        email: "joao@example.com",
        aniversario: "10/10/1995",
        bancos: ["Banco do Brasil", "Caixa Econômica", "Nubank"]
    };

    return (
        <div className={styles.perfilcontainer}>
            <h2>Perfil</h2>
            <div className={styles.perfilinfo}>
                <p><strong>Nome:</strong> {usuario.nome}</p>
                <p><strong>Email:</strong> {usuario.email}</p>
            </div>
        </div>
    );
};

export default Perfil;