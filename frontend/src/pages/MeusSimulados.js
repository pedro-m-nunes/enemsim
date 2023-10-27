import React, { useEffect, useState } from 'react'
import { useLocation, useNavigate } from 'react-router-dom';
import NavBar from '../components/NavBar';
import axios from 'axios';
import toast from 'react-hot-toast';
import '../components/estilos/meussimulados.css';

export default function MeusSimulados() {
    const location = useLocation();
    const navigate = useNavigate();
    const[simulados, setSimulados] = useState([{}]);

    //executa na entrada do site
    useEffect(()=>{
        setSimulados(location.state)
    },[]);

    function lerResponderSim(simuladoRecebido, id) {
      if(simuladoRecebido.data.finalizado == false) {
        axios.get('http://localhost:8080/simulado/' + id + '/itens')
        .then(response => (
          toast.loading('Carregando imagens: tende a demorar dependendo de sua conexão', {duration: 4000}),
          navigate(
            '/simulado',
            {
              state: {
                  itens: response.data,
                  simulado: simuladoRecebido.data,
                  retorno: '/meussimulados'
              }
            })
        ))
        .catch(function (error) {
          if (error.response) {
            toast.error(error.response.data.message);
          } else if (error.request) {
            toast.error('Sistema fora do ar');
          } else {
            toast.error('Erro:', error.message);
          }
        })
      } else {
        toast.error('Simulado já finalizado!')
      } 

    }

    function abrirSimulado(id) {
        axios.get('http://localhost:8080/simulado/'+ id)
        .then(response => (
            lerResponderSim(response, id)
        ))
        .catch(function (error) {
            if (error.response) {
              toast.error(error.response.data.message);
            } else if (error.request) {
              toast.error('Sistema fora do ar');
            } else {
              toast.error('Erro:', error.message);
            }
          })
    }

  return (
    <div>
        <NavBar
        nomePagina={'Meus Simulados'}
        destino='/inicio'
        saida='VOLTAR'/>
        <div id='blcoo'>
        {simulados.map((simulados, index) => (
                <div key={index} id='bloco-acesso'>
                    <h1 id='nome-acesso'>{'Simulado n°' + simulados.id}</h1>
                    <h1 id='btn-acesso' onClick={() => abrirSimulado(simulados.id)}>Acessar simulado</h1>
                </div>
            ))}
        </div>
    </div>
  )
}
