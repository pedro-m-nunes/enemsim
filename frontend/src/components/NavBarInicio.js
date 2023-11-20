import React, { useState } from 'react'
import './estilos/navbar.css';
import logo from '../images/Logo.png';
import logoBranco from '../images/LogoBranco.png';
import audio from '../images/foxy-jumpscare-fnaf-2.mp3';
import foxy from '../images/foxy.png';
import { useNavigate } from 'react-router-dom';

function NavBarInicio( props ) {
    const navigate = useNavigate();

    const[imagem,setImg]=useState(logo);
    const[val,setVal]=useState(1);

    function delay(time) {
        return new Promise(resolve => setTimeout(resolve, time));
    }

    async function alterarImg() {
        setVal(val + 1);
        if(val === 5) {
            setImg(foxy);
            new Audio(audio).play();
            delay(2000).then(() => setImg(logo));
            setVal(0);
        }
    }

    function voltar() {
        const sairBoolean = window.confirm("Deseja sair de sua conta?");
        if(sairBoolean) {
            localStorage.removeItem('id');
            navigate(
                props.destino,
                {state:props.usuario}
            );
        }
    }

  return (
    <div id='nav'>
        <img src={imagem} id='logoImg' onClick={() => alterarImg()} alt='Logo do EnemSim'/>
        <h1 id="titulo-pagina">{props.nomePagina}</h1>
        <button onClick={() => voltar()} id='btn'>{props.saida}</button>
    </div>
  )
}

export default NavBarInicio
