import styles from '../styles/components/perfil.module.css'
import { useAuth } from '../context/AuthProvider';

const Perfil = () => {
    const { token } = useAuth();

    return (
        <div className={styles.perfilcontainer}>
            <h2>Perfil</h2>
            <div className={styles.perfilinfo}>
                <p><strong>Nome:</strong> {token.name}</p>
                <p><strong>Email:</strong> {token.email}</p>
            </div>
        </div>
    );
};

export default Perfil;