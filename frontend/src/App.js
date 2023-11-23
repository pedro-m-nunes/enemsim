import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './pages/Login';
import { Toaster } from 'react-hot-toast';
import PaginaInicial from './pages/PaginaInicial';
import ResponderSimulado from './pages/ResponderSimulado';
import MeusSimulados from './pages/MeusSimulados';
import LerSimulado from './pages/LerSimulado';
import GerarSimulados from './pages/GerarSimulados';
import VerSimulado from './pages/VerSimulado';
import { useEffect, useState } from 'react';

function App() {
  const[toastPosistion, setPos] = useState("top-center");

  useEffect(() => {
    const res = window.innerWidth;

    if(res < 900) {
      setPos("bottom-center");
    } else {
      setPos("top-center");
    }
  },[])

  return (
    <>
    <Toaster position={toastPosistion}/>
    <BrowserRouter>
        <Routes>
            <Route element = { <Login/> }  path="/"/>
            <Route element = { <PaginaInicial/>} path="/inicio"/>
            <Route element = { <GerarSimulados/> } path="/gerarsimulados"/>
            <Route element = { <MeusSimulados/> }  path="/meussimulados" />
            <Route element = { <ResponderSimulado/> }  path="/simulado"/>
            <Route element = { <LerSimulado/>} path="/lersimulado"/>
            <Route element = { <VerSimulado/> } path="versimulado"/>
        </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
