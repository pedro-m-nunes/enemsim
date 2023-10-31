import React, { useEffect, useState } from 'react'
import NavBar from '../components/NavBar'
import { useLocation, useNavigate } from 'react-router-dom';
import axios from 'axios';
import toast from 'react-hot-toast';
import { requestBaseUrl } from '../url';

function ResponderSimulado() {
    const location = useLocation();
    const navigate = useNavigate();

    let [values] = useState([]);
    const[itens,setItens] = useState([{}]);

    useEffect(() => {
      setItens(location.state.itens);
    },[])

    itens.map((itens, index) => (
      values[index] = 
      {
          id: {
              simuladoId: location.state.simulado.id,
              itemId: itens.id
          },
          resposta: null
      }
    ))

    function onRes(index, i, res) {
        values[index] = 
        {
            id: {
                simuladoId: location.state.simulado.id,
                itemId: i
            },
            resposta: res
        };
    }

    const enviarForm = (e) => {
        document.body.scrollTop = document.documentElement.scrollTop = 0;
        e.preventDefault();
        console.log(values);
        axios.post((requestBaseUrl + 'simulado/finalizar'), values)
        .then(
            navigate(
              "/lersimulado",
              {state: {
                itens: itens,
                respostas: values
              }})
        )
        .catch(function (error) {
          if (error.response) {
            toast.error(error.response.data.message);
          } else if (error.request) {
            toast.error('Não foi possível se conectar ao sistema.');
          } else {
            toast.error('Erro: ', error.message);
          }}
        )
    }
    
  return (
    <div>
        <NavBar
        nomePagina={'Responder Simulado'}
        destino='/inicio'
        saida='VOLTAR'
        />
        <form className="form-block" onSubmit={(e) => enviarForm(e)}>
            {
            itens.map((itens, index) => (
                <div key={index} id='container'>
                    <h1>Questão {index+1}</h1>
                    <iframe width='600vw' height='500vh' src={'https://drive.google.com/file/d/' + itens.imagemDriveId + '/preview'} title={'Questão' + itens.id} id='img-frame'/>
                    <div className='options'>
                        <div className='btn-option'>
                            <input type="radio" name={"res"+index+1} id={"A"+index} value="A" onChange={()=>onRes(index, itens.id, 'A')}/>
                            <label htmlFor={"A"+index}>A</label>
                        </div>
                        <div className='btn-option'>
                            <input type="radio" name={"res"+index+1} id={"B"+index} value="B" onChange={()=>onRes(index, itens.id, 'B')}/>
                            <label htmlFor={"B"+index}>B</label>
                        </div>
                        <div className='btn-option'>
                            <input type="radio" name={"res"+index+1} id={"C"+index} value="C" onChange={()=>onRes(index, itens.id, 'C')}/>
                            <label htmlFor={"C"+index}>C</label>
                        </div>
                        <div className='btn-option'>
                            <input type="radio" name={"res"+index+1} id={"D"+index} value="D" onChange={()=>onRes(index, itens.id, 'D')}/>
                            <label htmlFor={"D"+index}>D</label>
                        </div>
                        <div className='btn-option'>
                            <input type="radio" name={"res"+index+1} id={"E"+index} value="E" onChange={()=>onRes(index, itens.id, 'E')} size='10px'/>
                            <label htmlFor={"E"+index}>E</label>
                        </div>
                    </div>
                </div>
            ))
            }
            <button type="submit" id='btn-enviar'>ENVIAR</button>
        </form>
    </div>
  )
}

export default ResponderSimulado
