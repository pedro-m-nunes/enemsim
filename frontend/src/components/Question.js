import React, { useState , useEffect } from 'react';
import axios from 'axios';

export default function Question() {
 
    const[questions,setQuestions]=useState([{}]);
    const[idSimulado,setInfo]=useState({});

    async function clic() {
        let linkBase = 'http://localhost:8080';
        let linkCerto = linkBase + '/simulado/gerar/nivelamento/estudante=1';
        const response = await axios.get(linkCerto);
        const q = response.data.itens;
        const idSimulado = response.data.simulado.id;
        setQuestions(q);
        setInfo(idSimulado);
    }

    useEffect(()=>{
         clic();
    },[]);

    const printA = (e) => {
        e.preventDefault();        
        console.log(questions);
        console.log(idSimulado);
    }

    // const loadQuestions = async() => {
    //     const result = await axios.get("http://localhost:8080/item/1");
    //     setQuestions(result.data);
    // }

    // function clic() {
    //     loadQuestions();
    //     console.log(questions);
    // }
    
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
    }

    return (
        <div>
            <form className="form-block" onSubmit={(e) => enviarForm(e)}>
            {
            questions.map((questions, index) => (
                <div key={index+1}>
                    <h1>Questão {index+1}</h1>
                    <iframe width='50%' height='500vh' src={'https://drive.google.com/file/d/' + questions.imagemDriveId + '/preview'} title={'Questão' + questions.id}/>
                    <br />
                    <input type="radio" name={"res"+index+1} id="A" value="A" onChange={()=>onRes(index, questions.id, 'A')}/> A
                    <input type="radio" name={"res"+index+1} id="B" value="B" onChange={()=>onRes(index, questions.id, 'B')}/> B
                    <input type="radio" name={"res"+index+1} id="C" value="C" onChange={()=>onRes(index, questions.id, 'C')}/> C
                    <input type="radio" name={"res"+index+1} id="D" value="D" onChange={()=>onRes(index, questions.id, 'D')}/> D
                    <input type="radio" name={"res"+index+1} id="E" value="E" onChange={()=>onRes(index, questions.id, 'E')}/> E
                    <br />
                </div>
            ))
            }
            <br />
            <button type="submit">ENVIAR</button>
            <button onClick={(e) => printA(e)}>IMPRIMIR</button>
            </form>
        </div>
    )
}