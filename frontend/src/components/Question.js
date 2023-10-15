import React, { useState , useEffect } from 'react';
import axios from 'axios';import './estilos/question.css';

export default function Question() {
   
    const[itens,setItens]=useState([{}]);
    const[idSimulado,setInfo]=useState({});

    async function carregarItens() {
        const dadosBrutos = await axios.get('http://localhost:8080/simulado/gerar/nivelamento/estudante=' + 1);
        const itens = dadosBrutos.data.itens;
        const idSimulado = dadosBrutos.data.simulado.id;
        setItens(itens);
        setInfo(idSimulado);
    }

    //executa na entrada do site
    useEffect(()=>{
        carregarItens();
    },[]);
    
    //resposta para o BD
    const [values] = useState([]);
    function onRes(index, i, res) {
        values[index] = 
        {
            id: {
                simuladoId: idSimulado,
                itemId: i
            },
            resposta: res
        };
    }
    
    const enviarForm = (e) => {
        e.preventDefault();
        console.log(values);
        axios.post('http://localhost:8080/simulado/finalizar', values);
    }
    // onSubmit={(e) => enviarForm(e)}
    return (
        <div>
            <form className="form-block" onSubmit={(e) => enviarForm(e)}>
            {
            itens.map((itens, index) => (
                <div key={index} id='container'>
                    <h1>Questão {index+1}</h1>
                    <iframe width='600vw' height='500vh' src={'https://drive.google.com/file/d/' + itens.imagemDriveId + '/preview'} title={'Questão' + itens.id} id='img-frame'/>
                    <div className='options'>
                        <div className='btn-option'>
                            <input type="radio" name={"res"+index+1} id="A" value="A" onChange={()=>onRes(index, itens.id, 'A')}/>
                            <label for="A">A</label>
                        </div>
                        <div className='btn-option'>
                            <input type="radio" name={"res"+index+1} id="B" value="B" onChange={()=>onRes(index, itens.id, 'B')}/>
                            <label for="B">B</label>
                        </div>
                        <div className='btn-option'>
                            <input type="radio" name={"res"+index+1} id="C" value="C" onChange={()=>onRes(index, itens.id, 'C')}/>
                            <label for="C">C</label>
                        </div>
                        <div className='btn-option'>
                            <input type="radio" name={"res"+index+1} id="D" value="D" onChange={()=>onRes(index, itens.id, 'D')}/>
                            <label for="D">D</label>
                        </div>
                        <div className='btn-option'>
                            <input type="radio" name={"res"+index+1} id="E" value="E" onChange={()=>onRes(index, itens.id, 'E')} size='10px'/>
                            <label for="E">E</label>
                        </div>
                    </div>
                </div>
            ))
            }
            <br />
            <button type="submit">ENVIAR</button>
            </form>
        </div>
    )
}