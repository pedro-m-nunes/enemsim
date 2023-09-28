package br.ifsul.enemsim.temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.controllers.SimuladoController;
import br.ifsul.enemsim.repositories.SimuladoRepository;
import jakarta.annotation.PostConstruct;

@Component
@DependsOn({"insertUsuarios", "insertItens"})
public class InsertSimuladosDeNivelamento {
	
	@Autowired
	private SimuladoController simuladoController;
	
	@Autowired
	private SimuladoRepository simuladoRepository;
	
	@PostConstruct
	public void run() {
		if(simuladoRepository.count() == 0) { // ?
			simuladoController.gerarSimuladoDeNivelamento(1);
		}
	}

}
