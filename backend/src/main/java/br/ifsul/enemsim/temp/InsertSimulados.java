package br.ifsul.enemsim.temp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.exceptions.DadosInsuficientesException;
import br.ifsul.enemsim.gerador.Distribuicao;
import br.ifsul.enemsim.gerador.Filtro;
import br.ifsul.enemsim.gerador.GerSim;
import jakarta.annotation.PostConstruct;

@Component
@DependsOn("insertItens")
public class InsertSimulados {

	@Autowired
	private GerSim gerador;
	
	@PostConstruct
	public void run() throws DadosInsuficientesException {
		gerador.gerarSimulado(10);
//		gerador.gerarSimulado(5);
//		gerador.gerarSimulado(10);
//		gerador.gerarSimulado(45);
//		gerador.gerarSimulado(400);
		
		gerador.gerarSimulado(new Distribuicao(
				new Filtro[] {
						new Filtro(new Habilidade((byte) 1), BigDecimal.valueOf(-1), BigDecimal.valueOf(2)), 
						new Filtro(new Habilidade((byte) 2), null, null), 
						new Filtro(new Habilidade((byte) 3), BigDecimal.ONE, null), 
						new Filtro(new Habilidade((byte) 4), null, BigDecimal.ONE)
				}, 
				new Integer[] {5, 5, 5, 5}
				));
		
		gerador.gerarSimulado(5);
		
		gerador.gerarSimulado(new Distribuicao(
				new Filtro[] {
						new Filtro(new Habilidade((byte) 1), BigDecimal.valueOf(-1), BigDecimal.valueOf(2)), 
						new Filtro(new Habilidade((byte) 1), BigDecimal.valueOf(2), null)
				}, 
				new Integer[] {7, 3}
				));
		
		gerador.gerarSimulado(new Distribuicao(
				new Filtro[] {
						new Filtro(null, BigDecimal.ZERO, BigDecimal.ONE), 
						new Filtro(null, null, BigDecimal.ZERO), 
						new Filtro(null, BigDecimal.ONE, null)
				}, 
				new Integer[] {3, 3, 3}
				));
		
	}
	
}
