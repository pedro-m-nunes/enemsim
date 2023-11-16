import React, { useEffect, useState } from 'react'
import NavBarSim from '../components/NavBarSim'
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
      toast.loading('Carregando imagens. Pode levar alguns segundos.', {duration: 4000});
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

    function onReset(index, i) {
      values[index] = 
      {
          id: {
              simuladoId: location.state.simulado.id,
              itemId: i
          },
          resposta: null
      };
  }

  const enviarForm = (e) => {
    e.preventDefault();
    const enviarBoolean = window.confirm("Deseja finalizar o simulado?");

    if(enviarBoolean) {
      const enviarPromise = axios.post((requestBaseUrl + 'simulado/finalizar'), values);
      document.body.scrollTop = document.documentElement.scrollTop = 0;

      toast.promise(
        enviarPromise, 
        {
          loading: 'Enviando simulado...',
          success: () => {
            navigate(
              "/lersimulado",
              {state: {
                itens: itens,
                respostas: values
            }});
            
            return 'Simulado finalizado com sucesso!'
          },
          error: (error) => {
            if (error.response) {
              return error.response.data.message;
            } else if (error.request) {
              return 'Não foi possível conectar-se ao sistema.';
            } else {
              return 'Erro:', error.message;
            }
          },
        }
      )
    }
  }
    
  return (
    <div>
        <NavBarSim
        nomePagina={'Responder Simulado'}
        destino='/inicio'
        saida='VOLTAR'
        />
        <form className="form-block" onSubmit={(e) => enviarForm(e)}>
            {
            itens.map((itens, index) => (
                <form key={index} className='container' id={'container'+index}>
                    <h1>Questão {index+1}</h1>
                    <iframe width='600vw' height='500vh' src={'https://drive.google.com/file/d/' + itens.imagemDriveId + '/preview'} title={'Questão' + itens.id} className='img-frame'/>
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
                        <div className='btn-option'>
                            <button type="reset" name="reset-btn" id="reset-btn" value={null} onClick={()=>onReset(index, itens.id)} size='10px'>Limpar</button>
                        </div>
                    </div>
                </form>
            ))
            }
            <button id='btn-enviar'>ENVIAR</button>
        </form>
    </div>
  )
}

export default ResponderSimulado
