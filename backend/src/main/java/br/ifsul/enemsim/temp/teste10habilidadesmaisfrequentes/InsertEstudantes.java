package br.ifsul.enemsim.temp.teste10habilidadesmaisfrequentes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.domain.usuarios.Estudante;
import br.ifsul.enemsim.repositories.usuarios.EstudanteRepository;
import br.ifsul.enemsim.repositories.usuarios.UsuarioRepository;
import jakarta.annotation.PostConstruct;

@Component
public class InsertEstudantes {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EstudanteRepository estudanteRepository;
	
	@PostConstruct
	public void run() {
		if(estudanteRepository.count() == 0) {
			
			// turmas?
			// testar simulados e afins com os estudantes (o banco aguenta?)
			
			List<Estudante> projetistas = new ArrayList<>();
			projetistas.add(new Estudante("joaoguiss", "enemsim_joao", "João Guilherme Severo Schröer"));
			projetistas.add(new Estudante("pedromn", "enemsim_pedro", "Pedro Müller Nunes"));
			projetistas.add(new Estudante("roberto", "enemsim_roberto", "Roberto Maurício Bokowski Sobrinho"));
			projetistas.add(new Estudante("monica", "enemsim_monica", "Mônica Xavier Py"));
			
			List<Estudante> estudantesQuinta = new ArrayList<>();
			estudantesQuinta.add(new Estudante("080880EVEQ", "zk2ib0", "Alana R. N."));
			estudantesQuinta.add(new Estudante("20211SS.INF_Q0074", "nxotcu", "Alessandra V. L. C."));
			estudantesQuinta.add(new Estudante("079520EVEQ", "e3dxll", "Ana L. B. V."));
			estudantesQuinta.add(new Estudante("079590EVEQ", "xzd2ur", "Brenda R. M. M."));
			estudantesQuinta.add(new Estudante("080180EVEQ", "fx9vpr", "Dafny B. S."));
			estudantesQuinta.add(new Estudante("20211SS.EVE_Q0061", "tn6kyc", "Eduarda S. C."));
			estudantesQuinta.add(new Estudante("078780INFQ", "wm4fuh", "Gabriel M. P."));
			estudantesQuinta.add(new Estudante("079480EVEQ", "xkvz7l", "Gabrielle F. S. B."));
			estudantesQuinta.add(new Estudante("20231SS.TDS_Q0033", "3gv2j3", "João H. P."));
			estudantesQuinta.add(new Estudante("20211SS.INF_Q0028", "z9qirl", "João T. R. R."));
			estudantesQuinta.add(new Estudante("080210EVEQ", "bgyt2u", "Karolinne V. M."));
			estudantesQuinta.add(new Estudante("079610EVEQ", "uhi5fi", "Kauã F. S."));
			estudantesQuinta.add(new Estudante("079780EVEQ", "ab9sh4", "Laura V. L."));
			estudantesQuinta.add(new Estudante("079430EVEQ", "3gkd1e", "Maiara G. S."));
			estudantesQuinta.add(new Estudante("079530EVEQ", "m5fre0", "Maria E. S. D."));
			estudantesQuinta.add(new Estudante("079390EVEQ", "fohham", "Maria L. A. A."));
			estudantesQuinta.add(new Estudante("079800EVEQ", "jf2imo", "Nicole O. C."));
			estudantesQuinta.add(new Estudante("20221SS.INF_Q0002", "9lrsfk", "Nicoly F. G. K."));
			estudantesQuinta.add(new Estudante("079450EVEQ", "cln0hl", "Rafaela B. C."));
			estudantesQuinta.add(new Estudante("079490EVEQ", "ynrvvq", "Thaissa R. D."));
			estudantesQuinta.add(new Estudante("20221SS.INF_Q0004", "vgviat", "Vinícius R. R."));
			estudantesQuinta.add(new Estudante("20211SS.INF_Q0011", "kufgqt", "Vitória P."));
			
			List<Estudante> estudantesSegunda = new ArrayList<>();
			estudantesSegunda.add(new Estudante("079850EVEQ", "agygde", "Alanis O. H."));
			estudantesSegunda.add(new Estudante("079680EVEQ", "cqibn4", "Amanda R."));
			estudantesSegunda.add(new Estudante("080650EVEQ", "e29e3u", "Carolyne M. J."));
			estudantesSegunda.add(new Estudante("075820EVEQ", "wzguo0", "Danielle F. V."));
			estudantesSegunda.add(new Estudante("079640EVEQ", "l5bcj8", "Gabriela M. R. S."));
			estudantesSegunda.add(new Estudante("079630EVEQ", "g5ewi5", "Larissa T. R. M."));
			estudantesSegunda.add(new Estudante("080220EVEQ", "vjxdle", "Laura C. A."));
			estudantesSegunda.add(new Estudante("080890EVEQ", "2ruqie", "Mariana N. P."));
			estudantesSegunda.add(new Estudante("079810EVEQ", "ieqlj3", "Mehll R."));
			estudantesSegunda.add(new Estudante("079690EVEQ", "sxnns6", "Raíssa O. B."));
			estudantesSegunda.add(new Estudante("079840EVEQ", "7kowgd", "Rochelly A. S."));
			estudantesSegunda.add(new Estudante("079730EVEQ", "6xtawr", "Samantha M. T."));
			estudantesSegunda.add(new Estudante("079770EVEQ", "lb0l7k", "Thauane S. M."));

			List<Estudante> extras = new ArrayList<>(); // Caso haja algum problema com algum usuário
			extras.add(new Estudante("extra1", "111111", "Extra 1"));
			extras.add(new Estudante("extra2", "222222", "Extra 2"));
			extras.add(new Estudante("extra3", "333333", "Extra 3"));
			extras.add(new Estudante("extra4", "444444", "Extra 4"));
			extras.add(new Estudante("extra5", "555555", "Extra 5"));
			extras.add(new Estudante("extra6", "666666", "Extra 6"));
			
			
			
			List<Estudante> estudantesTotais = new ArrayList<>();
			estudantesTotais.addAll(projetistas);
			estudantesTotais.addAll(estudantesQuinta);
			estudantesTotais.addAll(estudantesSegunda);
			estudantesTotais.addAll(extras);
			
			usuarioRepository.saveAll(estudantesTotais); // service?
		}
	}

}
