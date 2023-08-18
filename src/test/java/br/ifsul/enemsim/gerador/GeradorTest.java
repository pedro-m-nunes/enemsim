package br.ifsul.enemsim.gerador;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.ifsul.enemsim.exceptions.DadosInsuficientesException;

@SpringBootTest
public class GeradorTest {

	@Autowired
	Gerador gerador;
	
	@Test
	public void geradorDeveGerarUmaListaComAQuantidadeCorreta() throws DadosInsuficientesException {
		Assert.assertEquals(10, gerador.gerarSimulado(10).size());
		Assert.assertEquals(5, gerador.gerarSimulado(5).size());
		Assert.assertEquals(20, gerador.gerarSimulado(20).size());
		Assert.assertEquals(45, gerador.gerarSimulado(45).size());
	}
	
	// habilidade e níveis de dificuldade em simulados gerados com filtros
	
	// ...
	
}
