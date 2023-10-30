import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Filter from './components/Filter';
import Login from './pages/Login';
import { Toaster } from 'react-hot-toast';
import PaginaInicial from './pages/PaginaInicial';
import ResponderSimulado from './pages/ResponderSimulado';
import MeusSimulados from './pages/MeusSimulados';
import LerSimulado from './pages/LerSimulado';
import GerarSimulados from './pages/GerarSimulados';
import VerSimulado from './pages/VerSimulado';

function App() {
  return (
    <>
    <Toaster/>
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
