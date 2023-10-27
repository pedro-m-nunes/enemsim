import React, { useEffect, useState } from 'react'
// import LinkBlock from '../components/LinkBlock'
import '../components/estilos/linkblock.css'
import '../components/estilos/genericopage.css';
import NavBarInicio from '../components/NavBarInicio.js';
import { useNavigate } from 'react-router-dom';
import toast from 'react-hot-toast';
import axios from 'axios';

export default function PaginaInicial() {
  const navigate = useNavigate();

  function gerarSim() {
    console.log("Gerando novo simulado")
    axios.post('http://localhost:8080/simulado/gerar/nivelamento', { id : sessionStorage.getItem('id') })
    .then(response => (
        toast.loading('Carregando imagens: tende a demorar dependendo de sua conexão', {duration: 4000}),
        navigate(
          '/simulado',
          {state:response.data})
        ))
    .catch(function (error) {
        if (error.response) {
          toast.error(error.response.data.message);
        } else if (error.request) {
          toast.error('Sistema fora do ar');
        } else {
          toast.error('Erro:', error.message);
        }
      });
  }

  function abrirMeusSimulados() {
    console.log("Abrindo simulados");
    axios.get('http://localhost:8080/simulado/estudante/' + sessionStorage.getItem('id'))
    .then(response => (
      navigate(
        '/meussimulados',
        {
          state: response.data
        }
      )
    ))
    .catch(function (error) {
      if (error.response) {
        toast.error(error.response.data.message);
      } else if (error.request) {
        toast.error('Sistema fora do ar');
      } else {
        toast.error('Erro:', error.message);
      }
    });
  }

  return (
    <>
        <NavBarInicio
          nomePagina={"Página Inicial"}
          saida="SAIR"
          destino="/"/>
        <div id='meio'>

          <div id='bloco' onClick={() => gerarSim()}>
            <img id='gerarSim' src="https://thenounproject.com/api/private/icons/4650215/edit/?backgroundShape=SQUARE&backgroundShapeColor=%23000000&backgroundShapeOpacity=0&exportSize=752&flipX=false&flipY=false&foregroundColor=%23000000&foregroundOpacity=1&imageFormat=png&rotation=0" alt='Botão de destino à página de gerar simulados'/>
            <label className='texto' htmlFor='gerarSim'>Gerar Simulados</label>
          </div>

          <div id='bloco' onClick={() => abrirMeusSimulados()}>
            <img id='meusSim' src="https://thenounproject.com/api/private/icons/4612125/edit/?backgroundShape=SQUARE&backgroundShapeColor=%23000000&backgroundShapeOpacity=0&exportSize=752&flipX=false&flipY=false&foregroundColor=%23000000&foregroundOpacity=1&imageFormat=png&rotation=0" alt='Botão de destino à página de Meus Simulado'/>
            <label className='texto' htmlFor='meusSim'>Meus Simulados</label>
          </div>        
        </div>
    </>
    )  
}
