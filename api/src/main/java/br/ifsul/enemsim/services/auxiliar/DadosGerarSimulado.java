package br.ifsul.enemsim.services.auxiliar;

import br.ifsul.enemsim.domain.auxiliar.Adaptacao;
import br.ifsul.enemsim.domain.auxiliar.Area;
import br.ifsul.enemsim.domain.usuarios.Estudante;

public record DadosGerarSimulado(Estudante estudante, Area area, Adaptacao adaptacao) {

}
