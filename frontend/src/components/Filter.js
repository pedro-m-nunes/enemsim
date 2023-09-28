import React, { useState } from 'react';
// import axios from 'axios';

export default function Filter() {

    const [num,setNum] = useState(0);
    const [area,setArea] = useState();
    const [hab,setHab] = useState();
    const [diff,setDiff] = useState();
    const [dif1,setDif1] = useState('Neutro');

    const subFilter = (e) => {
        const sub = {
            numero: num,
            areaConhecimento: area,
            habilidade: hab,
            dificuldade: diff
        }
        e.preventDefault();
        console.log(sub);
    }

    function getDiff(e) {
        setDiff(e)
        if(e == -2) {
            setDif1('Muito Fácil')
        } else if(e == -1) {
            setDif1('Fácil')
        } else if(e == 0) {
            setDif1('Neutro')
        } else if(e == 1) {
            setDif1('Difícil')
        } else if(e == 2) {
            setDif1('Muito Difícil')
        }
    }

    return (
        <div>
            <form action="" id="filterForm" onSubmit={(e) => subFilter(e)}>
                <label htmlFor="num">Número de Questões</label>
                <br />
                <input type="number" name='num' id='num' size='4' required onChange={(e) => setNum(e.target.value)}></input>
                <br />
                <br />

                <label htmlFor="area">Área</label>
                <br />
                <select name="area" id="area" required onChange={(e) => setArea(e.target.value)}>
                    <option value="" disabled selected>Selecione a Área</option>
                    <option value="MT">Matemática e suas tecnologias</option>
                </select>
                <br />
                <br />

                <label htmlFor="hab"> Habilidade </label>
                <br />
                <select name="hab" id="hab" required onChange={(e) => setHab(e.target.value)}> 
                    <option value="" disabled selected>Selecione a habilidade</option>
                    <option value="1" >Reconhecer, no contexto social, diferentes significados e representações dos números e operações - naturais, inteiros, racionais ou reais.</option>
                    <option value="2">Identificar padrões numéricos ou princípios de contagem.</option>
                    <option value="3">Resolver situação-problema envolvendo conhecimentos numéricos.</option>
                    <option value="4">Avaliar a razoabilidade de um resultado numérico na construção de argumentos sobre afirmações quantitativas.</option>
                </select>
                <br />
                <br />

                <label htmlFor="diff"> Dificuldade: {dif1}</label>
                <br />
                <input type="range" name="diff" id="diff" min='-2' max='2' value={diff} onChange={(e) => getDiff(e.target.value)}/>
                <br />
                <br />

                <button type='submit'>ENVIAR</button> <button type='reset'>LIMPAR</button>
            </form>
        </div>
    )
}