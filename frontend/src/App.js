import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Filter from './components/Filter';
import Login from './pages/Login';
import { Toaster } from 'react-hot-toast';
import PaginaInicial from './pages/PaginaInicial';
import ResponderSimulado from './pages/ResponderSimulado';
import MeusSimulados from './pages/MeusSimulados';
import LerSimulado from './pages/LerSimulado';

function App() {
  return (
    <>
    <Toaster/>
    <BrowserRouter>
        <Routes>
            <Route element = { <Login/> }  path="/"/>
            <Route element = { <ResponderSimulado/> }  path="/simulado"/>
            <Route element = { <MeusSimulados/> }  path="/meussimulados" />
            <Route element = { <Filter/> }  path="/filtro" />
            <Route element = { <PaginaInicial/>} path="/inicio"/>
            <Route element = { <LerSimulado/>} path="/lersimulado"/>
        </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
