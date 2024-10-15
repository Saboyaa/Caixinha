import React from 'react';
import styles from '../styles/components/sidebar.module.css'
import { AiFillHome } from 'react-icons/ai';
import { AiOutlineBarChart } from 'react-icons/ai';
import { FaDollarSign, FaExchangeAlt } from 'react-icons/fa';
import { FaUser } from 'react-icons/fa';




const Sidebar = (string) => {
  
  return (
    <div className={styles.sidebar}>
      <div className={styles.sidebarmenu}>
        <div className={styles.navlink}>
          <AiFillHome style={{marginRight: "5px", color: "4cd080"}}/>
          <h2>Principal</h2>
        </div>
        <div className={styles.navlink}>
          <AiOutlineBarChart style={{marginRight: "5px", color: "4cd080"}}/>
          <h2>Estátisticas</h2>
        </div>
        <div className={styles.navlink}>
          <FaDollarSign style={{marginRight: "5px", color: "4cd080"}}/>
          <h2>Investimentos</h2>
        </div>
        <div className={styles.navlink}>
          <FaUser style={{marginRight: "5px", color: "4cd080"}}/>
          <h2>Perfil</h2>
        </div>
      </div>
      <div className={styles.logout}>
        <button className={styles.logoutbutton}>
          <span>Logout</span>
        </button>
      </div>
    </div>
  );
};

export default Sidebar;