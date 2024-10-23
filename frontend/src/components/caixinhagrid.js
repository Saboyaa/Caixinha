import styles from '../styles/components/caixinhagrid.module.css'

const Caixinhagrid = ({Array}) => {
    return(
        <div className={styles.caixinhasgrid}>
            {Array.map((item, index) => (
            <div key={index} className={styles.caixinha}>
                <p>{item.nome}</p>
                <p>R$ {item.valor}</p>
            </div>
            ))}
       </div>
    )
}

export default Caixinhagrid