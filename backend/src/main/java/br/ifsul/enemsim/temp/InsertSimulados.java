package br.ifsul.enemsim.temp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.exceptions.DadosInsuficientesException;
import br.ifsul.enemsim.exceptions.DistribuicaoException;
import br.ifsul.enemsim.gerador.Distribuicao;
import br.ifsul.enemsim.gerador.Filtro;
import br.ifsul.enemsim.gerador.GerSim;
import br.ifsul.enemsim.repositories.SimuladoRepository;
import br.ifsul.enemsim.repositories.entidadesrelacionais.SimuladoItemRepository;
import jakarta.annotation.PostConstruct;

@Component
@DependsOn("insertItens")
public class InsertSimulados { // mover para test?

	@Autowired
	private GerSim gerador;

	@Autowired
	private SimuladoRepository simuladoRepository;

	@Autowired
	private SimuladoItemRepository simuladoItemRepository;

	@PostConstruct
	public void run() throws DadosInsuficientesException {

		try {
//			gerador.gerarSimulado(10).save(simuladoRepository, simuladoItemRepository);

			gerador.gerarSimulado(new Distribuicao(
					new Filtro[] {
							new Filtro(new Habilidade((byte) 1), BigDecimal.valueOf(-1), BigDecimal.valueOf(2)), 
							new Filtro(new Habilidade((byte) 2), null, null), 
							new Filtro(new Habilidade((byte) 3), BigDecimal.ONE, null), 
							new Filtro(new Habilidade((byte) 4), null, BigDecimal.ONE)
					}, 
					new Integer[] {5, 5, 5, 5}
					)).save(simuladoRepository, simuladoItemRepository);

//			gerador.gerarSimulado(5).save(simuladoRepository, simuladoItemRepository);

			gerador.gerarSimulado(new Distribuicao(
					new Filtro[] {
							new Filtro(new Habilidade((byte) 1), BigDecimal.valueOf(-1), BigDecimal.valueOf(2)), 
							new Filtro(new Habilidade((byte) 1), BigDecimal.valueOf(2), null)
					}, 
					new Integer[] {7, 3}
					)).save(simuladoRepository, simuladoItemRepository);

			gerador.gerarSimulado(new Distribuicao(
					new Filtro[] {
							new Filtro(null, BigDecimal.ZERO, BigDecimal.ONE), 
							new Filtro(null, null, BigDecimal.ZERO), 
							new Filtro(null, BigDecimal.ONE, null)
					}, 
					new Integer[] {3, 3, 3}
					)).save(simuladoRepository, simuladoItemRepository);

			gerador.gerarSimulado(new Distribuicao(
					new Filtro[] {
							new Filtro(null, BigDecimal.ZERO, BigDecimal.ONE), 
							new Filtro(null, null, BigDecimal.ZERO), 
							new Filtro(null, BigDecimal.ONE, null)
					}, 
					new Integer[] {3, 3, 3}
					)).save(simuladoRepository, simuladoItemRepository);
			
		} catch(DistribuicaoException e) {}

	}

}
