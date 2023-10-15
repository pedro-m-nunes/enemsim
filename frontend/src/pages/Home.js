import { Link, useLocation } from 'react-router-dom';

const Home = () => {
  const location = useLocation();
  console.log(location.state);

  // const dadosBrutos = 
  // const dados = dadosBrutos.data;

  return (
      <div>
        <Link to='/'>Login</Link>
        <br />
        <Link to='/question'>Resolver Simulado</Link>
        <br />
        <Link to='/filtro'>Filtrar questões</Link>
      </div>
  )
}

export default Home
