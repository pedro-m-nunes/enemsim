import React from 'react'
import NavBar from '../components/NavBar'
import Question from '../components/Question';
import { useLocation } from 'react-router-dom';

function ResponderSimulado() {
    const location = useLocation();
    // console.log(location.state.user);
    
  return (
    <div>
        <NavBar
        nomePagina={'Responder Simulado'}
        destino='/inicio'
        saida='VOLTAR'
        />
        <Question idSim={location.state}/>
    </div>
  )
}

export default ResponderSimulado
