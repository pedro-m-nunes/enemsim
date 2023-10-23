import React, { useEffect, useState } from 'react'
import NavBar from '../components/NavBar'
import { useLocation } from 'react-router-dom'
import '../components/estilos/question.css'
import '../components/estilos/lersimulado.css'

export default function LerSimulado() {
    const location = useLocation();
    const[acertos, setAcertos]=useState();
    const[respostas, setRespostas]=useState([]);
    //location.state.itens
    //location.state.respostas

    const arrayEnviado = location.state;
    const itens = arrayEnviado.itens;

    useEffect(() => {
        //contagem de respostas
        let acertosTemp = 0;
        for(let i = 0; i < 10; i++) {
            if(arrayEnviado.itens[i].respostaCerta === arrayEnviado.respostas[i].resposta) {
                acertosTemp = acertosTemp + 1;
            } else {
                acertosTemp = acertosTemp;
            }
        }
        setAcertos(acertosTemp)
        console.log(acertos)
    },[])

    useEffect(() => {
        //definindo as respostas
        for(let i = 0; i < 10; i++) {
            if(arrayEnviado.respostas[i].resposta === null) {
                respostas[i] = 'Questão não respondida';
            } else {
                respostas[i] = arrayEnviado.respostas[i].resposta;
            }
        }
        console.log(respostas)
    },[])

    return (
    <>
        <NavBar
        nomePagina={'Revisar Simulado'}
        destino='/inicio'
        saida='SAIR DA REVISÃO'/>
        <h1 id='acertos'>Você acertou {acertos}/10, uma taxa de {acertos * 10}% de acertos</h1>
        {
        itens.map((itens, index) => (
            <div key={index} id='container'>
                <h1>Questão {index+1}</h1>
                <iframe width='600vw' height='500vh' src={'https://drive.google.com/file/d/' + itens.imagemDriveId + '/preview'} title={'Questão' + itens.id} id='img-frame'/>
                <p className='respostas'>RESPOSTA: {respostas[index]}</p>
                <p className='respostas'>RESPOSTA CERTA: {itens.respostaCerta}</p>
            </div>
        ))}
    </>
    )
}