package br.ifsul.enemsim.temp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.gerador.GeradorSimulados;
import br.ifsul.enemsim.repositories.SimuladoRepository;
import jakarta.annotation.PostConstruct;

@Component
@DependsOn("insertItens")
public class InsertSimulados {

	@Autowired
	private GeradorSimulados gerador;
	
	@Autowired
	private SimuladoRepository simuladoRepository;
	
	@PostConstruct
	public void run() {
		List<Simulado> simulados = new ArrayList<>();
		
		simulados.add(gerador.gerar(10));
		simulados.add(gerador.gerar(10));
		simulados.add(gerador.gerar(5));
		
		simuladoRepository.saveAll(simulados);
	}
	
}
