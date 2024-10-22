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
            <h2>Perfil do Usuário</h2>
            <div className={styles.perfilinfo}>
                <p><strong>Nome:</strong> {usuario.nome}</p>
                <p><strong>Email:</strong> {usuario.email}</p>
                <p><strong>Data de Aniversário:</strong> {usuario.aniversario}</p>
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