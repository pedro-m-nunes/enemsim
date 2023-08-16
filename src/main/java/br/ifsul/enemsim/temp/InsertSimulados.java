package br.ifsul.enemsim.temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.exceptions.DadosInsuficientesException;
import br.ifsul.enemsim.gerador.Gerador;
import jakarta.annotation.PostConstruct;

@Component
@DependsOn("insertItens")
public class InsertSimulados {

	@Autowired
	private Gerador gerador;
	
	@PostConstruct
	public void run() throws DadosInsuficientesException {
		gerador.gerarSimulado(10);
		gerador.gerarSimulado(5);
		gerador.gerarSimulado(10);
		gerador.gerarSimulado(45);
//		gerador.gerarSimulado(400);
		
		// ...
	}
	
}
