import styles from '../styles/components/saldo.module.css'

const Saldo = () => {
    return(
        <div>
                                <div className={styles.ola}>
                        <h1>Olá, [nome]</h1>
                    </div>
                    <div className={styles.saldoTotal}>
                        <h2  style={{ color: '#8F92A1', fontWeight:"normal" }}>Saldo Total Disponível:</h2>
                        <h2>R$ [saldoTotal]</h2>
                    </div>
                    <div className={styles.meusSaldos}>
                        <h1>Meus saldos</h1>
                    </div>
                    <div className={styles.bancos}>
                        <div className={styles.banco}>
                            <h2 className = {styles.img}>img</h2>
                            <h2 className = {styles.nome}>nome</h2>
                            <h2 className = {styles.saldo}>Saldo</h2>
                        </div>
                    </div>
        </div>
    )
}

export default Saldo;