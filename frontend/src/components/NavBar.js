import React, { useState } from 'react'
import './estilos/navbar.css';
import logo from '../images/Logo.png';
import logoBranco from '../images/LogoBranco.png';

function NavBar( props ) {

    const[imagem,setImg]=useState(logo);
    const[val,setVal]=useState(true);
    function alterarImg() {
        if(val === true) {
            setImg(logoBranco);
            setVal(false);
        } else if(val === false) {
            setImg(logo);
            setVal(true);
        }
    }

    function voltar() {

    }

  return (
    <div id='nav'>
        <img src={imagem} id='logoImg' onClick={() => alterarImg()} alt='Logo do EnemSim'/>
        <h1 id="pagina">EnemSim / {props.nomePagina}</h1>
        <button onClick={voltar} id='btn'>{props.saida}</button>
    </div>
  )
}

export default NavBar
