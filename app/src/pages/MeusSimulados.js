import React, { useEffect, useState } from 'react'
import { useLocation, useNavigate } from 'react-router-dom';
import NavBar from '../components/NavBar';
import axios from 'axios';
import toast from 'react-hot-toast';
import '../components/estilos/meussimulados.css';
import { requestBaseUrl } from '../url';
import '../components/estilos/genericopage.css';

export default function MeusSimulados() {
    const location = useLocation();
    const navigate = useNavigate();
    const[simulados, setSimulados] = useState([{}]);

    useEffect(() => {
      if(localStorage.getItem('id') === null || localStorage.getItem('id') === undefined) {
        navigate('/');
      }
    },[]);

    //executa na entrada do site
    useEffect(()=>{
        setSimulados(location.state);
    },[]);

    function lerResponderSim(simuladoRecebido, id) {
      if(simuladoRecebido.data.finalizado === false) {
        axios.get((requestBaseUrl + 'simulado/') + id + '/itens')
        .then(response => (
          navigate(
            '/simulado',
            {
              state: {
                  itens: response.data,
                  simulado: simuladoRecebido.data
              }
            })
        ))
        .catch(function (error) {
          if (error.response) {
            toast.error(error.response.data.message);
          } else if (error.request) {
            toast.error('Não foi possível se conectar ao sistema.');
          } else {
            toast.error('Erro: ', error.message);
          }
        })
      } else {
        axios.get((requestBaseUrl + 'simulado/') + id + '/respostas')
        .then(response => (
          navigate(
            '/versimulado',
            {state: response.data})
        ))
        .catch(function (error) {
          if (error.response) {
            toast.error(error.response.data.message);
          } else if (error.request) {
            toast.error('Não foi possível se conectar ao sistema.');
          } else {
            toast.error('Erro: ', error.message);
          }
        })
      } 

    }

    function abrirSimulado(id) {
      const abrirPromise = axios.get(requestBaseUrl + 'simulado/'+ id);

      toast.promise(
        abrirPromise,
        {
          loading: 'Carregando simulado...',
          success: (response) => {
            lerResponderSim(response, id);
            return 'Simulado carregado com sucesso!';
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
    <div>
        <NavBar
        nomePagina={'Meus Simulados'}
        destino='/inicio'
        saida='VOLTAR'/>
        <div>
          {simulados.map((simulados, index) => {
            if(simulados.finalizado === false) {
              return <div key={index} className='bloco-acesso n-respondido' id={'bloco-acesso'+index}>
                        <h1 id='nome-acesso'>{'Simulado ' + (index + 1) + ' - Não finalizado'}</h1>
                        <h1 id='btn-acesso' onClick={() => abrirSimulado(simulados.id)}>Responder</h1>
                     </div>;
            } else {
              return <div key={index} className='bloco-acesso' id={'bloco-acesso'+index}>
                        <h1 id='nome-acesso'>{'Simulado ' + (index + 1)}</h1>
                        <h1 id='btn-acesso' onClick={() => abrirSimulado(simulados.id)}>Acessar</h1>
                     </div>;
            }
            })}
        </div>
    </div>
  )
}
