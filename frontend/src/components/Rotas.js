import React from "react";
import { Routes, Route, BrowserRouter } from "react-router-dom";

import Login from '../pages/Login.js';
import Home from '../pages/Home.js';
import Question from "./Question.js";
import Filter from "./Filter.js";

const Rotas = () => {
   return(
       <BrowserRouter>
            <Routes>
                <Route component = { Login }  path="/"/>
                <Route component = { Home }  path="/home"/>
                <Route component = { Question }  path="/question" />
                <Route component = { Filter }  path="/filtro" />
            </Routes>
       </BrowserRouter>
   )
}

export default Rotas;