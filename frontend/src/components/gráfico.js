import styles from '../styles/components/gráfico.module.css'
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip } from 'recharts';

const Gráfico = ({ array }) => {
    const agruparGastos = (data) => {
        return data.reduce((acc, curr) => {
            const existente = acc.find(item => item.motivo === curr.motivo);
            if (existente) {
                existente.valor += curr.valor;
            } else {
                acc.push({ ...curr });
            }
            return acc;
        }, []);
    };

    const dataAgrupada = agruparGastos(array);

    return (
        <div className={styles.grafico}>
            <BarChart width={800} height={400} data={dataAgrupada} margin={{ top: 5, right: 30, left: 30, bottom: 5 }}>
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis dataKey="motivo" />
                <YAxis />
                <Tooltip />
                <Bar dataKey="valor" fill="#4dd081" />
            </BarChart>
        </div>
    );
}

export default Gráfico;