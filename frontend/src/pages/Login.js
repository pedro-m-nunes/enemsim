import React, { useEffect } from 'react'
import { useState } from 'react'
// import Rotas from '../components/Rotas';
import { useNavigate } from 'react-router-dom';
import '../components/estilos/login.css'
import logo from '../images/Logo.png';
import toast from 'react-hot-toast';
import axios from 'axios';

const Login = () => {
    // definir POST no axios / mandar dados ao banco
  const navigate = useNavigate();

  const[user, setUser] = useState('');
  const[senha, setSenha] = useState('');
  const[id, setId] = useState('');

  // useEffect(()=>{
  // },[]);

  const handleSubmit = (e) => {
    let login = {
      usuario: user,
      senha: senha
    }
    e.preventDefault();
    if(validar()) {
      toast.success('Campos preenchidos!')
      axios.post('http://localhost:8080/auth/login', login).then(response => { console.log(response) });
      console.log(id)
    }
    // navigate(
    //   '/inicio',
    //   {state:
    //     {user, senha}
    //   }
    // );
  }

  const validar = () => {
    let validate = true;
    if(user === null || user ==='') {
      toast.error('Usuário não preenchido')
      validate = false;
    }
    if(senha === null || senha ==='') {
      toast.error('Senha não preenchida')
      validate = false;
    }

    return validate;
  }

  return (
    <div id='base'>
      <div id='logoTit'>
        <img src={logo} alt="Logo do EnemSim" id='logo'/>
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
