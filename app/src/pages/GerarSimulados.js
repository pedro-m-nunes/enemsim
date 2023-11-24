import React, { useEffect } from 'react'
import '../components/estilos/linkblock.css'
import '../components/estilos/genericopage.css';
import { Navigate, useNavigate} from 'react-router-dom';
import toast from 'react-hot-toast';
import axios from 'axios';
import { requestBaseUrl } from '../url';
import NavBar from '../components/NavBar';
import nivelamentoImg from '../images/gerarNivelamento.png';
import desempenhoImg from '../images/gerarDesempenho.png';

export default function GerarSimulados() {
  const navigate = useNavigate();
  
  useEffect(() => {
    if(localStorage.getItem('id') === null || localStorage.getItem('id') === undefined) {
      navigate('/');
    }
  },[]);

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

  function gerarNivelamento() {
    const simuladoPromise = axios.post((requestBaseUrl + 'simulado/gerar/nivelamento'), { id : localStorage.getItem('id') }); 
                    
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
            if(error.response.data.message === "Não se pode gerar um novo simulado enquanto tiver um não finalizado.") {
              abrirMeusSimulados();
              return error.response.data.message;
            } else {
              return error.response.data.message;
            }
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
    const simuladoPromise = axios.post((requestBaseUrl + 'simulado/gerar/desempenho'), { id : localStorage.getItem('id') });

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
            if(error.response.data.message === "Não se pode gerar um novo simulado enquanto tiver um não finalizado.") {
              abrirMeusSimulados();
              return error.response.data.message;
            } else {
              return error.response.data.message;
            }
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
          nomePagina={"Gerar Simulado"}
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
