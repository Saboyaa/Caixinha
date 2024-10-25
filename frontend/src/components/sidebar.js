import React from 'react';
import styles from '../styles/components/sidebar.module.css'
import { AiOutlineBarChart } from 'react-icons/ai';
import { FaDollarSign } from 'react-icons/fa';
import { FaUser } from 'react-icons/fa';
import { useContext } from 'react';
import { AppContext } from '../context/AppContext';
import { useNavigate } from 'react-router-dom';
import { FaBoxOpen } from 'react-icons/fa';
import { FaHistory } from 'react-icons/fa';
import { useAuth } from '../context/AuthProvider';




const Sidebar = () => {
  const{ sb, setSb } = useContext(AppContext);
  const { setToken } = useAuth();

  const navigate = useNavigate();

  const b1 = () =>{
    setSb(1);
  }

  const b2 = () =>{
    setSb(2);
  }

  const b3 = () =>{
    setSb(3);
  }

  const b4 = () =>{
    setSb(4);
  }


  const logout = () =>{
    setToken({});
    navigate('/');
  }
  
  return (
    <div className={styles.sidebar}>
      <div className={styles.sidebarmenu}>
        <div className={styles.navlink}>
          <FaDollarSign style={{marginRight: "5px", color: "4cd080"}}/>
          <button onClick={b1} className={styles.btn}>Saldo</button>
        </div>
        <div className={styles.navlink}>
          <FaBoxOpen style={{marginRight: "5px", color: "4cd080"}}/>
          <button onClick={b2} className={styles.btn}>Lançamentos</button>
        </div>
        <div className={styles.navlink}>
          <FaHistory style={{marginRight: "5px", color: "4cd080"}}/>
          <button onClick={b3} className={styles.btn}>Estatísticas</button>
        </div>
        <div className={styles.navlink}>
          <AiOutlineBarChart style={{marginRight: "5px", color: "4cd080"}}/>
          <button onClick={b4} className={styles.btn}>Perfil</button>
        </div>
      </div>
      <div className={styles.logout}>
        <button className={styles.logoutbutton} onClick={logout}>
          <span>logout</span>
        </button>
      </div>
    </div>
  );
};

export default Sidebar;