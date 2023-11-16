import React, { useEffect, useState } from 'react'
import NavBar from '../components/NavBar'
import { useLocation, useNavigate } from 'react-router-dom'
import '../components/estilos/simulado.css'
import '../components/estilos/lersimulado.css'
import toast from 'react-hot-toast'

export default function LerSimulado() {
    const location = useLocation();
    const navigate = useNavigate();
    const[acertos, setAcertos]=useState();

    const arrayEnviado = location.state;
    const itens = arrayEnviado.itens;

    useEffect(() => {
        //contagem de acertos
        let acertosTemp = 0;
        for(let i = 0; i < 10; i++) {
            if(arrayEnviado.itens[i].respostaCerta === arrayEnviado.respostas[i].resposta) {
                acertosTemp = acertosTemp + 1;
            } else {
                acertosTemp = acertosTemp;
            }
        }
        setAcertos(acertosTemp)
        toast.loading('Carregando imagens. Pode levar alguns segundos.', {duration: 4000})
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
        itens.map((itens, index) => {
            const linkGoogle = 'https://www.google.com/search?q=enem+prova+'+ itens.prova.cor.toLowerCase() +'+'+ itens.prova.ano +'+quest%C3%A3o+'+ itens.numero;

            if(itens.respostaCerta === arrayEnviado.respostas[index].resposta) {
                return  <div key={index} id='container-certa'>
                            <h1 id='titulo-item'>Questão {index+1}</h1>
                            <iframe width='600vw' height='500vh' src={'https://drive.google.com/file/d/' + itens.imagemDriveId + '/preview'} title={'Questão' + itens.id} className='img-frame'/>
                            <p className='respostas'>Questão acertada!</p>
                            <p className='respostas'>Resposta: {itens.respostaCerta}</p>
                            <a className="buscar-google" href={linkGoogle} target='_blank'>Buscar questão no Google</a>
                        </div>
            } else if(arrayEnviado.respostas[index].resposta === null || arrayEnviado.respostas[index].resposta === undefined) {
                return  <div key={index} id='container-nulo'>
                            <h1 id='titulo-item'>Questão {index+1}</h1>
                            <iframe width='600vw' height='500vh' src={'https://drive.google.com/file/d/' + itens.imagemDriveId + '/preview'} title={'Questão' + itens.id} className='img-frame'/>
                            <p className="respostas">Questão não respondida.</p>
                            <p className='respostas'>Resposta certa: {itens.respostaCerta}</p>
                            <a className="buscar-google" href={linkGoogle} target='_blank'>Buscar questão no Google</a>
                        </div>
            } else {
                return  <div key={index} id='container-errada'>
                            <h1 id='titulo-item'>Questão {index+1}</h1>
                            <iframe width='600vw' height='500vh' src={'https://drive.google.com/file/d/' + itens.imagemDriveId + '/preview'} title={'Questão' + itens.id} className='img-frame'/>
                            <p className='respostas'>Questão errada... Resposta: {arrayEnviado.respostas[index].resposta}</p>
                            <p className="respostas">Resposta certa: {itens.respostaCerta}</p>
                            <a className="buscar-google" href={linkGoogle} target='_blank'>Buscar questão no Google</a>
                        </div>
            }
        })}
        <button onClick={() => sair()} id='btn-revisao'>SAIR DA REVISÂO</button>
    </>
    )
}