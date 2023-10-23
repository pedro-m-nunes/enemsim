import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import NavBar from '../components/NavBar';
import axios from 'axios';

export default function MeusSimulados() {
    const navigate = useNavigate();
    const[simulados, setSimulados] = useState([{}]);

    // const location = useLocation();
    // console.log(location.state.user);

    async function carregarSimulado() {
        const listaSimulados = await axios.get('http://localhost:8080/simulado/estudante/' + 1); //1 é a id do estudante, no final será variável
        setSimulados(listaSimulados.data);
    }

    //executa na entrada do site
    useEffect(()=>{
        carregarSimulado();
    },[]);

    function abrirSimulado( simId ) {
        navigate(
            '/simulado',
            {state: simId}
        )
    }

  return (
    <div>
        <NavBar
        nomePagina={'Meus Simulados'}
        destino='/inicio'
        saida='VOLTAR'/>
        <div id='blcoo'>
        {simulados.map((simulados, index) => (
                <div id={'blocoSimulado' + index}>
                    <h1 id='titulo-simulado'>{'Simulado n°' + simulados.id}</h1>
                    <h1 id='acessar-simulado' onClick={() => abrirSimulado(simulados.id)}>Acessar simulado</h1>
                    <button type='reset' onClick={() => abrirSimulado(simulados.id)}>teste</button>
                </div>
            ))}
        </div>
    </div>
  )
}
