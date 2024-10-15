import React from 'react';
import styles from '../styles/components/header1.module.css';
import { Link } from 'react-router-dom';

const Header1 = () => {
  return (
    <header className={styles.header}>
      <div className={styles.headerlogo}>Caixinha</div>
      <nav className={styles.headernav}>
        <div className={styles.lnk}>
          <Link to='/cadastro' style={{fontFamily: "Roboto", color: "white", fontSize:"20px", textDecoration: "none"}}>CRIE UMA CONTA</Link>
        </div>
        <div className={styles.lnk}>
          <Link to='/login' style={{fontFamily: "Roboto", color: "white", fontSize:"20px", textDecoration: "none"}}>ENTRE NA SUA CONTA</Link>
        </div>
      </nav>
    </header>
  );
}

export default Header1;
