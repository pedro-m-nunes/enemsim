import React, { useEffect, useState } from 'react'
import NavBar from '../components/NavBar'
import { useLocation, useNavigate } from 'react-router-dom'
import '../components/estilos/simulado.css'
import '../components/estilos/lersimulado.css'
import toast from 'react-hot-toast'

export default function VerSimulado() {
    const location = useLocation();
    const navigate = useNavigate();
    const[acertos, setAcertos]=useState();

    const dados = location.state;

    useEffect(() => {
        //contagem de respostas
        let acertosTemp = 0;
        for(let i = 0; i < 10; i++) {
            if(dados[i].resposta === dados[i].item.respostaCerta) {
                acertosTemp = acertosTemp + 1;
            }
        }
        setAcertos(acertosTemp);
        toast.loading('Carregando imagens. Pode levar alguns segundos.', {duration: 4000});
    },[])

    function sair() {
        navigate('/inicio')
    }

    return (
    <>
        <NavBar
        nomePagina={'Revisar Simulado'}
        destino='/inicio'
        saida='SAIR DA REVISÃO'/>
        <h1 id='acertos'>Você acertou {acertos}/10, uma taxa de {acertos * 10}% de acertos.</h1>
        {
        dados.map((dados, index) => {
            if(dados.resposta === dados.item.respostaCerta) {
                return  <div key={index} id='container-certa'>
                            <h1 id='titulo-item'>Questão {index+1}</h1>
                            <iframe src={'https://drive.google.com/file/d/' + dados.item.imagemDriveId + '/preview'} title={'Questão' + dados.id.itemId} className='img-frame'/>
                            <p className='respostas'>Questão acertada!</p>
                            <p className='respostas'>Resposta: {dados.resposta}</p>
                            <a className="buscar-google" href={'https://www.google.com/search?q=enem+prova+'+ dados.item.prova.cor.toLowerCase() +'+'+ dados.item.prova.ano +'+quest%C3%A3o+'+ dados.item.numero} target='_blank'>Buscar questão no Google</a>
                        </div>
            } else if(dados.resposta === null || dados.resposta === undefined) {
                return  <div key={index} id='container-nulo'>
                            <h1 id='titulo-item'>Questão {index+1}</h1>
                            <iframe src={'https://drive.google.com/file/d/' + dados.item.imagemDriveId + '/preview'} title={'Questão' + dados.id.itemId} className='img-frame'/>
                            <p className="respostas">Questão não respondida.</p>
                            <p className='respostas'>Resposta certa: {dados.item.respostaCerta}</p>
                            <a className="buscar-google" href={'https://www.google.com/search?q=enem+prova+'+ dados.item.prova.cor.toLowerCase() +'+'+ dados.item.prova.ano +'+quest%C3%A3o+'+ dados.item.numero} target='_blank'>Buscar questão no Google</a>
                        </div>
            } else {
                return  <div key={index} id='container-errada'>
                            <h1 id='titulo-item'>Questão {index+1}</h1>
                            <iframe src={'https://drive.google.com/file/d/' + dados.item.imagemDriveId + '/preview'} title={'Questão' + dados.id.itemId} className='img-frame'/>
                            <p className='respostas'>Questão errada... Resposta: {dados.resposta}</p>
                            <p className="respostas">Resposta certa: {dados.item.respostaCerta}</p>
                            <a className="buscar-google" href={'https://www.google.com/search?q=enem+prova+'+ dados.item.prova.cor.toLowerCase() +'+'+ dados.item.prova.ano +'+quest%C3%A3o+'+ dados.item.numero} target='_blank'>Buscar questão no Google</a>
                        </div>
            }
        })}
        <button onClick={() => sair()} id='btn-revisao'>SAIR DA REVISÃO</button>
    </>
    )
}