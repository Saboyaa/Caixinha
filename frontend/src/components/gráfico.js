import styles from '../styles/components/gráfico.module.css'
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from 'recharts';

const Gráfico = ({array}) => {
    return(
        <div className={styles.grafico}>
            <BarChart width={800} height={400} data={array} margin={{ top: 5, right: 30, left: 30, bottom: 5 }}>
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis dataKey="motivo" />
                <YAxis />
                <Tooltip />
                {/* <Legend /> */}
                <Bar dataKey="valor" fill="#4dd081" />
            </BarChart>
        </div>
    )
}

export default Gráfico