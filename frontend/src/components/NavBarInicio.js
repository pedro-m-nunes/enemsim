import React, { useState } from 'react'
import './estilos/navbar.css';
import logo from '../images/Logo.png';
import logoBranco from '../images/LogoBranco.png';
import { useNavigate } from 'react-router-dom';

function NavBarInicio( props ) {
    const navigate = useNavigate();

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
        sessionStorage.removeItem('id');
        navigate(
            props.destino,
            {state:props.usuario}
        );
    }

  return (
    <div id='nav'>
        <img src={imagem} id='logoImg' onClick={() => alterarImg()} alt='Logo do EnemSim'/>
        <h1 id="titulo-pagina">EnemSim / {props.nomePagina}</h1>
        <button onClick={() => voltar()} id='btn'>{props.saida}</button>
    </div>
  )
}

export default NavBarInicio
