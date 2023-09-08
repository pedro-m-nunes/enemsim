package br.ifsul.enemsim.temp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.auxiliar.Resposta;
import br.ifsul.enemsim.entidades.relacionais.SimuladoItem;
import br.ifsul.enemsim.repositories.entidadesrelacionais.SimuladoItemRepository;
import jakarta.annotation.PostConstruct;

@Component
@DependsOn("insertSimulados")
public class EditSimulados {
	
	@Autowired
	private SimuladoItemRepository simuladoItemRepository;
	
	@PostConstruct
	public void run() {
		List<SimuladoItem> simuladoItens = simuladoItemRepository.findBySimulado(new Simulado(1));
		
		for(SimuladoItem simuladoItem : simuladoItens)
			simuladoItem.setResposta(Resposta.A);
		
		simuladoItens.get(0).getSimulado().setFinalizado(true); // ?
		
		simuladoItemRepository.saveAll(simuladoItens);
		
		simuladoItens = simuladoItemRepository.findBySimulado(new Simulado(3));
		
		for(SimuladoItem simuladoItem : simuladoItens)
			simuladoItem.setResposta(Resposta.B);
		
		simuladoItens.get(0).getSimulado().setFinalizado(true); // ?
		
		simuladoItemRepository.saveAll(simuladoItens);
	}
	
}
