import React, { useEffect } from 'react'
import { useState } from 'react'
// import Rotas from '../components/Rotas';
import { useNavigate } from 'react-router-dom';
import '../components/estilos/login.css'
import logo from '../images/Logo.png';

const Login = () => {
    // definir POST no axios / mandar dados ao banco
    // definir tela de home melhor
  const navigate = useNavigate();

  const[user, setUser] = useState();
  const[senha, setSenha] = useState();

  // useEffect(()=>{
  // },[]);

    const handleSubmit2 = (e) => {
      e.preventDefault();
      navigate('/inicio', {state:{user, senha}});
    }

  return (
    <div id='base'>
      <div id='logoTit'>
        <img src={logo} alt="Logo do EnemSim" id='logo'/>
        <h1 id='titulo'>EnemSim</h1>
      </div>
      <form onSubmit={handleSubmit2}>
        <input type="text" id='user' onChange={(e) => setUser(e.target.value)} placeholder='Usuário' className='coiso'/>
        <input type="password" id='senha' onChange={(e) => setSenha(e.target.value)} placeholder='Senha' className='coiso'/>
        <div id='botoes'>
          <button className='coiso' id='btn1'>Cadastro</button>
          <button type='submit' className='coiso' id='btn2'>Login</button>
        </div>
      </form>
    </div>
  )
}

export default Login;
