import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import './estilos/linkblock.css';

export default function LinkBlock( props ) {
    //Variáveis: { nome, imagemLink, destino, alt }

    const[img,setImg]=useState();
    useEffect(()=>{
        setImg(props.imagemLink);
    },[]);

    function linkarTela() {

    }

    //estilizar samerda
    
  return (
    <div id='bloco'>
      <img id={props.nome} src={img} alt={props.alt}/>
      <label className='texto' htmlFor={props.nome}>{props.nome}</label>
    </div>
  )
}
