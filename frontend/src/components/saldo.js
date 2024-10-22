import styles from '../styles/components/saldo.module.css'

const Saldo = () => {
    return(
        <div className={styles.container}>
                    <div className={styles.ola} style={{marginBottom: '20px'}}>
                        <h1>Olá, [nome]</h1>
                    </div>
                    <div className={styles.saldoTotal} style={{marginBottom: '30px'}}>
                        <h2  style={{ color: '#8F92A1', fontWeight:"normal",  marginRight: '30px'}}>Saldo Total Disponível:</h2>
                        <h2>R$ [saldoTotal]</h2>
                    </div>
                    <div className={styles.meusSaldos}>
                        <h1>Meus saldos</h1>
                    </div>
                    <div className={styles.bancos}>
                        <div className={styles.banco}>
                            <h3 className = {styles.img}>[img]</h3>
                            <h3 className = {styles.nome}>[nome]</h3>
                            <h3 className = {styles.saldo}>[Saldo]</h3>
                        </div>
                    </div>
        </div>
    )
}

export default Saldo;