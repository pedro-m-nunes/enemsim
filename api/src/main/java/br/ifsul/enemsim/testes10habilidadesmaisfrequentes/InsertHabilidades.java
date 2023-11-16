package br.ifsul.enemsim.testes10habilidadesmaisfrequentes;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.domain.Competencia;
import br.ifsul.enemsim.domain.Habilidade;
import br.ifsul.enemsim.domain.auxiliar.Area;
import br.ifsul.enemsim.repositories.HabilidadeRepository;
import jakarta.annotation.PostConstruct;

@Component
public class InsertHabilidades {

	@Autowired
	private HabilidadeRepository habilidadeRepository;
	
	@PostConstruct
	public void run() {
		if(habilidadeRepository.count() == 0) {
			Competencia c1 = new Competencia("Construir significados para os números naturais, inteiros, racionais e reais.", (byte) 1, Area.MT);
			Competencia c2 = new Competencia("Utilizar o conhecimento geométrico para realizar a leitura e a representação da realidade e agir sobre ela.", (byte) 2, Area.MT);
			Competencia c5 = new Competencia("Modelar e resolver problemas que envolvem variáveis socioeconômicas ou técnico-científicas, usando representações algébricas.", (byte) 5, Area.MT);
			Competencia c6 = new Competencia("Interpretar informações de natureza científica e social obtidas da leitura de gráficos e tabelas, realizando previsão de tendência, extrapolação, interpolação e interpretação.", (byte) 6, Area.MT);
			Competencia c7 = new Competencia("Compreender o caráter aleatório e não-determinístico dos fenômenos naturais e sociais e utilizar instrumentos adequados para medidas, determinação de amostras e cálculos de probabilidade para interpretar informações de variáveis apresentadas em uma distribuição estatística.", (byte) 7, Area.MT);
			
			Set<Habilidade> habilidades = new LinkedHashSet<>();
			
			habilidades.add(new Habilidade("Reconhecer, no contexto social, diferentes significados e representações dos números e operações - naturais, inteiros, racionais ou reais.", (byte) 1, c1));
			habilidades.add(new Habilidade("Identificar padrões numéricos ou princípios de contagem.", (byte) 2, c1));
			habilidades.add(new Habilidade("Resolver situação-problema envolvendo conhecimentos numéricos.", (byte) 3, c1));
			habilidades.add(new Habilidade("Avaliar a razoabilidade de um resultado numérico na construção de argumentos sobre afirmações quantitativas.", (byte) 4, c1));
			
			habilidades.add(new Habilidade("Identificar características de figuras planas ou espaciais.", (byte) 7, c2));
			habilidades.add(new Habilidade("Resolver situação-problema que envolva conhecimentos geométricos de espaço e forma.", (byte) 8, c2));
			
			habilidades.add(new Habilidade("Resolver situação-problema cuja modelagem envolva conhecimentos algébricos.", (byte) 21, c5));
			
			habilidades.add(new Habilidade("Resolver problema com dados apresentados em tabelas ou gráficos.", (byte) 25, c6));
			habilidades.add(new Habilidade("Analisar informações expressas em gráficos ou tabelas como recurso para a construção de argumentos.", (byte) 26, c6));
			
			habilidades.add(new Habilidade("Resolver situação-problema que envolva conhecimentos de estatística e probabilidade.", (byte) 28, c7));
			
			habilidadeRepository.saveAll(habilidades);
		}
	}
	
}
