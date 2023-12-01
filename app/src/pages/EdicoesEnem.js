import React, { useEffect } from 'react'
import { useLocation, useNavigate } from 'react-router-dom';
import NavBar from '../components/NavBar';
import '../components/estilos/meussimulados.css';
import '../components/estilos/genericopage.css';
import '../components/estilos/edicoes.css';

export default function EdicoesEnem() {
    const navigate = useNavigate();

    useEffect(() => {
        if(localStorage.getItem('id') === null || localStorage.getItem('id') === undefined) {
          navigate('/');
        }
      },[]);
    
    const edicoes = [
        {
            ano: 2015,
            url: "https://download.inep.gov.br/educacao_basica/enem/provas/2015/2015_PV_impresso_D2_CD5.pdf",
            gab: "https://download.inep.gov.br/educacao_basica/enem/gabaritos/2015/CADERNO_5_AMARELO_DOMINGO.pdf"
        },
        {
            ano: 2016,
            url: "https://download.inep.gov.br/educacao_basica/enem/provas/2016/2016_PV_impresso_D2_CD5.pdf",
            gab: "https://download.inep.gov.br/educacao_basica/enem/gabaritos/2016/GAB_ENEM_2016_DIA_2_05_AMARELO.pdf"
        },
        {
            ano: 2017,
            url: "https://download.inep.gov.br/educacao_basica/enem/provas/2017/2017_PV_impresso_D2_CD5.pdf",
            gab: "https://download.inep.gov.br/educacao_basica/enem/gabaritos/2017/cad_5_gabarito_amarelo_12112017.pdf"
        },
        {
            ano: 2018,
            url: "https://download.inep.gov.br/educacao_basica/enem/provas/2018/2018_PV_impresso_D2_CD5.pdf",
            gab: "https://download.inep.gov.br/educacao_basica/enem/gabaritos/2018/GAB_ENEM_2018_DIA_2_AMARELO.pdf"
        },
        {
            ano: 2019,
            url: "https://download.inep.gov.br/educacao_basica/enem/provas/2019/2019_PV_impresso_D2_CD5.pdf",
            gab: "https://download.inep.gov.br/educacao_basica/enem/gabaritos/2019/gabarito_2_dia_caderno_5_amarelo_aplicacao_regular.pdf"
        },
        {
            ano: 2020,
            url: "https://download.inep.gov.br/enem/provas_e_gabaritos/2020_PV_impresso_D2_CD5.pdf",
            gab: "https://download.inep.gov.br/enem/provas_e_gabaritos/2020_GB_impresso_D2_CD5.pdf"
        },
        {
            ano: 2021,
            url: "https://download.inep.gov.br/enem/provas_e_gabaritos/2021_PV_impresso_D2_CD5.pdf",
            gab: "https://download.inep.gov.br/enem/provas_e_gabaritos/2021_GB_impresso_D2_CD5.pdf"
        },
        {
            ano: 2022,
            url: "https://download.inep.gov.br/enem/provas_e_gabaritos/2022_PV_impresso_D2_CD5.pdf",
            gab: "https://download.inep.gov.br/enem/provas_e_gabaritos/2022_GB_impresso_D2_CD5.pdf"
        }
    ]

  return (
    <div>
        <NavBar
        nomePagina={'Edições anteriores: 2° dia'}
        destino='/inicio'
        saida='VOLTAR'/>
        <div>
          {edicoes.map((edicoes, index) => 
            <div key={index} className='bloco-acesso' id={'bloco-acesso'+index}>
                <h1 id='nome-acesso'>{'Enem ' + edicoes.ano}</h1>
                <h1 id='btn-prova' onClick={() => window.open(edicoes.url)}>Exame</h1>
                <h1 id='btn-gabarito' onClick={() => window.open(edicoes.gab)}>Gabarito</h1>
            </div>
            )}
        </div>
    </div>
  )
}
