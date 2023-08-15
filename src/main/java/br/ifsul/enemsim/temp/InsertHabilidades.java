package br.ifsul.enemsim.temp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.repositories.HabilidadeRepository;
import jakarta.annotation.PostConstruct;

@Component
public class InsertHabilidades {

	@Autowired
	private HabilidadeRepository habilidadeRepository;
	
	@PostConstruct
	public void run() {
		List<Habilidade> habilidades = new ArrayList<>();
		
		habilidades.add(Habilidade.builder().numero((short) 1).descricao("Reconhecer, no contexto social, diferentes significados e representações dos números e operações - naturais, inteiros, racionais ou reais.").build());
		habilidades.add(Habilidade.builder().numero((short) 2).descricao("Identificar padrões numéricos ou princípios de contagem.").build());
		habilidades.add(Habilidade.builder().numero((short) 3).descricao("Resolver situação-problema envolvendo conhecimentos numéricos.").build());
		habilidades.add(Habilidade.builder().numero((short) 4).descricao("Avaliar a razoabilidade de um resultado numérico na construção de argumentos sobre afirmações quantitativas.").build());
		
		habilidadeRepository.saveAll(habilidades);
	}
	
}
