import React from 'react'
import NavBar from '../components/NavBar'
import LinkBlock from '../components/LinkBlock'
import '../components/estilos/genericopage.css';

export default function PaginaInicial() {
  // const location = useLocation();
  // console.log(location.state.user);

  return (
    <>
        <NavBar
          nomePagina={"Página Inicial"}
          saida="SAIR"
          destino="/"/>
        <div id='meio'>
          <LinkBlock
            nome="Gerar Simulados"
            imagemLink="https://thenounproject.com/api/private/icons/4650215/edit/?backgroundShape=SQUARE&backgroundShapeColor=%23000000&backgroundShapeOpacity=0&exportSize=752&flipX=false&flipY=false&foregroundColor=%23000000&foregroundOpacity=1&imageFormat=png&rotation=0"
            destino="/simulado"
            alt="Botão de destino à página de Gerar Simulados"
            // usuario={location.state}
            tipo="0"/>

          <LinkBlock
            nome="Meus Simulados"
            imagemLink="https://thenounproject.com/api/private/icons/4612125/edit/?backgroundShape=SQUARE&backgroundShapeColor=%23000000&backgroundShapeOpacity=0&exportSize=752&flipX=false&flipY=false&foregroundColor=%23000000&foregroundOpacity=1&imageFormat=png&rotation=0"
            destino="/meussimulados"
            alt="Botão de destino à página de Meus Simulados"/>

            
          <LinkBlock
            nome="Lista de Questões"
            imagemLink="https://thenounproject.com/api/private/icons/1152429/edit/?backgroundShape=SQUARE&backgroundShapeColor=%23000000&backgroundShapeOpacity=0&exportSize=752&flipX=false&flipY=false&foregroundColor=%23000000&foregroundOpacity=1&imageFormat=png&rotation=0"
            destino="/"
            alt="Botão de destino à página de Login"/>
            
        </div>
    </>
    )  
}
