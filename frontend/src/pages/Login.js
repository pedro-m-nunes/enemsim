import React, { useEffect } from 'react'
import { useState } from 'react'
// import Rotas from '../components/Rotas';
import { useNavigate } from 'react-router-dom';
import '../components/estilos/login.css'
import logo from '../images/Logo.png';
import toast from 'react-hot-toast';
import axios from 'axios';
import { requestBaseUrl } from '../url';
import audio from '../images/roblox-oof-sound-effect.mp3';

const Login = () => {

  const navigate = useNavigate();
  const[user, setUser] = useState('');
  const[senha, setSenha] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    if(validar()) {
      axios.post(
        (requestBaseUrl + 'auth/login'),
        {username: user, senha: senha}
      ).then(
        response => {
          toast.success('Seja bem vindo(a) ' + response.data.nome + '!');
          sessionStorage.setItem('id', response.data.id);
          navigate('/inicio')
        }
      ).catch(function (error) {
        if (error.response) {
          toast.error(error.response.data.message);
        } else if (error.request) {
          toast.error('Não foi possível se conectar ao sistema.');
        } else {
          toast.error('Erro: ', error.message);
        }
      });
    }
  }

  const validar = () => {
    let validate = true;
    if(user === null || user ==='') {
      toast.error('Usuário não preenchido.')
      validate = false;
    }
    if(senha === null || senha ==='') {
      toast.error('Senha não preenchida.')
      validate = false;
    }

    return validate;
  }

  const playAudio = () => {
    new Audio(audio).play();
  }

  return (
    <div id='base'>
      <div id='logoTit'>
        <img src={logo} alt="Logo do EnemSim" id='logo' onClick={()=>playAudio()}/>
        <h1 id='titulo'>EnemSim</h1>
      </div>
      <form onSubmit={handleSubmit}>
        <input type="text" id='user' onChange={(e) => setUser(e.target.value)} placeholder='Usuário' className='coiso'/>
        <input type="password" id='senha' onChange={(e) => setSenha(e.target.value)} placeholder='Senha' className='coiso'/>
        <div id='botoes'>
          {/* <button className='coiso' id='btn1'>Cadastro</button> */}
          <button type='submit' className='coiso' id='btn2'>Login</button>
        </div>
      </form>
    </div>
  )
}

export default Login;
