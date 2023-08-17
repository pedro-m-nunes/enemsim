package br.ifsul.enemsim.temp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.exceptions.DadosInsuficientesException;
import br.ifsul.enemsim.gerador.Distribuicao;
import br.ifsul.enemsim.gerador.Filtro;
import br.ifsul.enemsim.gerador.Gerador;
import br.ifsul.enemsim.repositories.HabilidadeRepository;
import jakarta.annotation.PostConstruct;

@Component
@DependsOn("insertItens")
public class InsertSimulados {

	@Autowired
	private Gerador gerador;
	
	@Autowired
	private HabilidadeRepository habilidadeRepository;
	
	@PostConstruct
	public void run() throws DadosInsuficientesException {
		gerador.gerarSimulado(10);
//		gerador.gerarSimulado(5);
//		gerador.gerarSimulado(10);
//		gerador.gerarSimulado(45);
//		gerador.gerarSimulado(400);
		
		gerador.gerarSimulado(
				new Distribuicao(
						new Filtro[] {
								new Filtro(habilidadeRepository.findById((byte) 1).get(), BigDecimal.valueOf(-1), BigDecimal.valueOf(2)), 
								new Filtro(habilidadeRepository.findById((byte) 2).get(), null, null), 
								new Filtro(habilidadeRepository.findById((byte) 3).get(), BigDecimal.ONE, null), 
								new Filtro(habilidadeRepository.findById((byte) 4).get(), null, BigDecimal.ONE)
						}, 
						new int[] {5, 5, 5, 5}
						)
				);
		
		gerador.gerarSimulado(5);
		
		gerador.gerarSimulado(
				new Distribuicao(
						new Filtro[] {
								new Filtro(habilidadeRepository.findById((byte) 1).get(), BigDecimal.valueOf(-1), BigDecimal.valueOf(2)), 
								new Filtro(habilidadeRepository.findById((byte) 1).get(), BigDecimal.valueOf(2), null), 
						}, 
						new int[] {7, 3}
						)
				);
	}
	
}
