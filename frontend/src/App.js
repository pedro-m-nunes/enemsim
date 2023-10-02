import './App.css';
import { BrowserRouter, Route, Routes, Navigate } from 'react-router-dom';
import Question from './components/Question';
import Home from './pages/Home';
import Filter from './components/Filter';
import Login from './pages/Login';

function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route element = { <Login/> }  path="/"/>
            <Route element = { <Home/> }  path="/home"/>
            <Route element = { <Question/> }  path="/question" />
            <Route element = { <Filter/> }  path="/filtro" />
        </Routes>
    </BrowserRouter>
  );
}

export default App;