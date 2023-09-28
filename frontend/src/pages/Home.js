import React from 'react';
import { BrowserRouter, Link, useLocation } from 'react-router-dom';
import Rotas from '../components/Rotas';

const Home = () => {
  const location = useLocation();
  console.log(location.state);
  return (
      <li>
        <Link to='/'>Login</Link>
        <br />
        <Link to='/question'>Resolver questão</Link>
        <br />
        <Link to='/filtro'>Filtrar questões</Link>
      </li>
  )
}

export default Home
