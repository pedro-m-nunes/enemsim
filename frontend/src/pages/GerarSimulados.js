import React, { useEffect, useState } from 'react'
// import LinkBlock from '../components/LinkBlock'
import '../components/estilos/linkblock.css'
import '../components/estilos/genericopage.css';
import NavBarInicio from '../components/NavBarInicio.js';
import { useNavigate } from 'react-router-dom';
import toast from 'react-hot-toast';
import axios from 'axios';
import { requestBaseUrl } from '../url';
import NavBar from '../components/NavBar';

export default function GerarSimulados() {
  const navigate = useNavigate();

  function gerarNivelamento() {
    axios.post((requestBaseUrl + 'simulado/gerar/nivelamento'), { id : sessionStorage.getItem('id') })
    .then(response => (
        toast('Gerando simulado de nivelamento', { icon: '🧠' }),
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

  function gerarDesempenho() {
    console.log("Gerando novo simulado")
    axios.post((requestBaseUrl + 'simulado/gerar/desempenho'), { id : sessionStorage.getItem('id') })
    .then(response => (
        toast('Gerando simulado de desempenho', { icon: '🍎' }),
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

  return (
    <>
        <NavBar
          nomePagina={"Gerar Simulados"}
          saida="VOLTAR"
          destino="/inicio"/>

        <div id='meio'>
          <div id='bloco' onClick={() => gerarNivelamento()}>
            <img id='gerarSim' src="https://thenounproject.com/api/private/icons/4650215/edit/?backgroundShape=SQUARE&backgroundShapeColor=%23000000&backgroundShapeOpacity=0&exportSize=752&flipX=false&flipY=false&foregroundColor=%23000000&foregroundOpacity=1&imageFormat=png&rotation=0" alt='Botão de destino à página de gerar simulados'/>
            <label className='texto' htmlFor='gerarSim'>Nivelamento</label>
          </div>

          <div id='bloco' onClick={() => gerarDesempenho()}>
            <img id='meusSim' src="https://thenounproject.com/api/private/icons/5647325/edit/?backgroundShape=SQUARE&backgroundShapeColor=%23000000&backgroundShapeOpacity=0&exportSize=752&flipX=false&flipY=false&foregroundColor=%23000000&foregroundOpacity=1&imageFormat=png&rotation=0" alt='Botão de destino à página de Provas do Enem'/>
            <label className='texto' htmlFor='meusSim'>Por desempenho</label>
          </div>
        </div>
    </>
    )  
}
