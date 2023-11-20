import React  from 'react'
import '../components/estilos/linkblock.css'
import '../components/estilos/genericopage.css';
import NavBarInicio from '../components/NavBarInicio.js';
import { useNavigate } from 'react-router-dom';
import toast from 'react-hot-toast';
import axios from 'axios';
import { requestBaseUrl } from '../url';
import gerarImg from '../images/gerarImg.png';
import meusSim from '../images/meusSim.png';
import { useEffect } from 'react';

export default function PaginaInicial() {
  const navigate = useNavigate();

  useEffect(() => {
    if(localStorage.getItem('id') === null || localStorage.getItem('id') === undefined) {
      navigate('/');
    }
  },[]);
  
  function gerarSim() {
    navigate('/gerarsimulados');
  }

  function abrirMeusSimulados() {
    axios.get(requestBaseUrl + 'simulado/estudante/' + localStorage.getItem('id'))
    .then(response => {
      if(response.data.length) {
        navigate(
          '/meussimulados',
          {
            state: response.data
          }
        )
      } else {
        toast.error('Nenhum simulado foi gerado até o momento.')
      }
    })
    .catch(function (error) {
      if (error.response) {
        toast.error(error.response.data.message);
      } else if (error.request) {
        toast.error('Não foi possível se conectar ao sistema.');
      } else {
        toast.error('Erro: ', error.message);
      }
    });
  }

  return (
    <>
        <NavBarInicio
          nomePagina={"Página Inicial"}
          saida="SAIR"
          destino="/"/>
        <div id='pag'>

          <div id='blocoA' onClick={() => gerarSim()}>
            <img id='gerarSim' src={gerarImg} alt='Botão de destino à página de Gerar Simulados'/>
            <label className='texto' htmlFor='gerarSim'>Gerar Simulado</label>
          </div>

          <div id='bloco' onClick={() => abrirMeusSimulados()}>
            <img id='meusSim' src={meusSim} alt='Botão de destino à página de Meus Simulados'/>
            <label className='texto' htmlFor='meusSim'>Meus Simulados</label>
          </div>

        </div>
    </>
    )  
}
