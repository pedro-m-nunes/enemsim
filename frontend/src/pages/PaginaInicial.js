import React from 'react'
import NavBar from '../components/NavBar'
import LinkBlock from '../components/LinkBlock'
import '../components/estilos/genericopage.css';

export default function PaginaInicial() {

  return (
    <>
        <NavBar nomePagina="Página Inicial" saida="VOLTAR"/>
        <div id='meio'>
          <LinkBlock
            nome="Login"
            imagemLink="https://thenounproject.com/api/private/icons/2067830/edit/?backgroundShape=SQUARE&backgroundShapeColor=%23000000&backgroundShapeOpacity=0&exportSize=752&flipX=false&flipY=false&foregroundColor=%23000000&foregroundOpacity=1&imageFormat=png&rotation=0"
            destino="/"
            alt="Botão de destino à página de Login"/>

          <LinkBlock
            nome="Gerar Simulados"
            imagemLink="https://thenounproject.com/api/private/icons/4650215/edit/?backgroundShape=SQUARE&backgroundShapeColor=%23000000&backgroundShapeOpacity=0&exportSize=752&flipX=false&flipY=false&foregroundColor=%23000000&foregroundOpacity=1&imageFormat=png&rotation=0"
            destino="/"
            alt="Botão de destino à página de Login"/>

          <LinkBlock
            nome="Meus Simulados"
            imagemLink="https://thenounproject.com/api/private/icons/4612125/edit/?backgroundShape=SQUARE&backgroundShapeColor=%23000000&backgroundShapeOpacity=0&exportSize=752&flipX=false&flipY=false&foregroundColor=%23000000&foregroundOpacity=1&imageFormat=png&rotation=0"
            destino="/"
            alt="Botão de destino à página de Login"/>

            
          <LinkBlock
            nome="Lista de Questões"
            imagemLink="https://thenounproject.com/api/private/icons/1152429/edit/?backgroundShape=SQUARE&backgroundShapeColor=%23000000&backgroundShapeOpacity=0&exportSize=752&flipX=false&flipY=false&foregroundColor=%23000000&foregroundOpacity=1&imageFormat=png&rotation=0"
            destino="/"
            alt="Botão de destino à página de Login"/>
            
        </div>
    </>
    )  
}
