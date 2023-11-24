import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './estilos/linkblock.css';

export default function LinkBlock( props ) {
    //Variáveis: { nome, imagemLink, destino, alt }
    const navigate = useNavigate();
    const[img,setImg]=useState();

    useEffect(()=>{
        setImg(props.imagemLink);
    },[]);
   
  return (
    <div id='bloco' onClick={() => navigate(props.destino, {state: props.tipo})}>
      <img id={props.nome} src={img} alt={props.alt}/>
      <label className='texto' htmlFor={props.nome}>{props.nome}</label>
    </div>
  )
}
