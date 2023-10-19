import './App.css';
import { BrowserRouter, Route, Routes, Navigate } from 'react-router-dom';
import Question from './components/Question';
import Home from './pages/Home';
import Filter from './components/Filter';
import Login from './pages/Login';
import { Toaster } from 'react-hot-toast';
import PaginaInicial from './pages/PaginaInicial';

function App() {
  return (
    <>
    <Toaster/>
    <BrowserRouter>
        <Routes>
            <Route element = { <Login/> }  path="/"/>
            <Route element = { <Home/> }  path="/home"/>
            <Route element = { <Question/> }  path="/question" />
            <Route element = { <Filter/> }  path="/filtro" />
            <Route element = { <PaginaInicial/>} path="/inicio"/>
        </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
