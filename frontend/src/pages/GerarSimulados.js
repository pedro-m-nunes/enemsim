import React, { useEffect, useState } from 'react'
import '../components/estilos/linkblock.css'
import '../components/estilos/genericopage.css';
import NavBarInicio from '../components/NavBarInicio.js';
import { useNavigate } from 'react-router-dom';
import toast from 'react-hot-toast';
import axios from 'axios';
import { requestBaseUrl } from '../url';
import NavBar from '../components/NavBar';
import nivelamentoImg from '../images/gerarNivelamento.png';
import desempenhoImg from '../images/gerarDesempenho.png';

export default function GerarSimulados() {
  const navigate = useNavigate();
  const[erro, setErro] = useState('Erro.');

  function gerarNivelamento() {
    const simuladoPromise = axios.post((requestBaseUrl + 'simulado/gerar/nivelamento'), { id : sessionStorage.getItem('id') }); 
                    
    toast.promise(
      simuladoPromise,
      {
        loading: 'Gerando simulado de nivelamento...',
        success: (response) => {
          navigate(
            '/simulado',
            {state:response.data});
          return 'Simulado gerado!'
        },
        error: (error) => {
          if (error.response) {
            return error.response.data.message;
          } else if (error.request) {
            return 'Não foi possível conectar-se ao sistema.';
          } else {
            return 'Erro:', error.message;
          }
        },
      }
    )
  }

  function gerarDesempenho() {
    const simuladoPromise = axios.post((requestBaseUrl + 'simulado/gerar/desempenho'), { id : sessionStorage.getItem('id') });

    toast.promise(
      simuladoPromise,
      {
        loading: 'Analisando seu desempenho...',
        success: (response) => {
          navigate(
            '/simulado',
            {state:response.data});
          return 'Simulado gerado!'
        },
        error: (error) => {
          if (error.response) {
            return error.response.data.message;
          } else if (error.request) {
            return 'Não foi possível conectar-se ao sistema.';
          } else {
            return 'Erro:', error.message;
          }
        },
      }
    )
  }

  return (
    <>
        <NavBar
          nomePagina={"Gerar Simulados"}
          saida="VOLTAR"
          destino="/inicio"/>

        <div id='pag'>
          <div id='blocoA' onClick={() => gerarNivelamento()}>
            <img id='gerarSim' src={nivelamentoImg} alt='Botão de destino à página de gerar simulados'/>
            <label className='texto' htmlFor='gerarSim'>Nivelamento</label>
          </div>

          <div id='bloco' onClick={() => gerarDesempenho()}>
            <img id='meusSim' src={desempenhoImg} alt='Botão de destino à página de Provas do Enem'/>
            <label className='texto' htmlFor='meusSim'>Por desempenho</label>
          </div>
        </div>
    </>
    )  
}
