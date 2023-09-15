//package br.ifsul.enemsim.microdados;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.stereotype.Component;
//
//import br.ifsul.enemsim.entidades.Habilidade;
//import br.ifsul.enemsim.entidades.Item;
//import br.ifsul.enemsim.entidades.Prova;
//import br.ifsul.enemsim.entidades.auxiliar.Area;
//import br.ifsul.enemsim.entidades.auxiliar.Cor;
//import br.ifsul.enemsim.entidades.auxiliar.Resposta;
//import br.ifsul.enemsim.repositories.HabilidadeRepository;
//import br.ifsul.enemsim.repositories.ItemRepository;
//import br.ifsul.enemsim.repositories.ProvaRepository;
//import jakarta.annotation.PostConstruct;
//
//@Component
//@DependsOn({"insertHabilidades", "insertProvas"})
//public class Coisa {
//
//	@Autowired
//	private QuestaoController questaoController;
//	
//	@Autowired
//	private ItemRepository itemRepository;
//	
//	@Autowired
//	private ProvaRepository provaRepository;
//	
//	@Autowired
//	private HabilidadeRepository habilidadeRepository;
//	
//	@PostConstruct
//	public void run() {
//		// ...
//	}
//	
//}
