import React, { useEffect } from 'react'
import { useState } from 'react'
// import Rotas from '../components/Rotas';
import { useNavigate } from 'react-router-dom';

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
      navigate('/home', {state:{user, senha}});
    }

  return (
    <div>
      <form onSubmit={handleSubmit2}>
        <br />
        <input type="text" id='user' onChange={(e) => setUser(e.target.value)} placeholder='Nome de usuário'/>
        <br />
        <input type="password" id='senha' onChange={(e) => setSenha(e.target.value)} placeholder='Senha'/>
        <br />
        <button type='submit'>ENTRAR</button>
      </form>
    </div>
  )
}

export default Login;
