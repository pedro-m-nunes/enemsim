//package br.ifsul.enemsim.gerador;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import br.ifsul.enemsim.entidades.Habilidade;
//import br.ifsul.enemsim.entidades.relacionais.SimuladoItem;
//import br.ifsul.enemsim.exceptions.DadosInsuficientesException;
//
//@SpringBootTest
//public class GerSimTest { // Alguns testes podem causar DadosInsuficientesException dependendo do preenchimento do banco, que é feito de forma aleatória.
//
//	@Autowired
//	private GerSim gerador;
//	
//	@Test
//	public void geradorDeveGerarUmaListaComAQuantidadeCorreta() throws DadosInsuficientesException {
//		Assert.assertEquals(10, gerador.gerarSimulado(10).size());
//		Assert.assertEquals(5, gerador.gerarSimulado(5).size());
//		Assert.assertEquals(20, gerador.gerarSimulado(20).size());
//		Assert.assertEquals(45, gerador.gerarSimulado(45).size());
//	}
//	
//	@Test
//	public void deveGerarUmSimuladoComCertoNumeroDeItensDeCadaHabilidade() throws DadosInsuficientesException {
//		Integer[] qtdsEsperadas = {23, 6, 31, 14};
//		
//		List<SimuladoItem> itens = gerador.gerarSimulado(new Distribuicao(
//				new Filtro[] {
//						new Filtro(new Habilidade((byte) 1), null, null), 
//						new Filtro(new Habilidade((byte) 2), null, null), 
//						new Filtro(new Habilidade((byte) 3), null, null), 
//						new Filtro(new Habilidade((byte) 4), null, null)
//				}, 
//				qtdsEsperadas
//				));
//		
//		Integer[] quantidades = {0, 0, 0, 0};
//		
//		for(SimuladoItem item : itens) {
//			quantidades[item.getItem().getHabilidade().getId() - 1]++;
//		}
//		
//		Assert.assertArrayEquals(qtdsEsperadas, quantidades);
//	}
//	
//	@Test
//	public void deveGerarUmSimuladoComDiferentesFaixasDeDificuldade() throws DadosInsuficientesException {
//		Integer[] qtdsEsperadas = {15, 5, 10};
//		
//		List<SimuladoItem> itens = gerador.gerarSimulado(new Distribuicao(
//				new Filtro[] {
//						new Filtro(null, null, BigDecimal.ZERO), 
//						new Filtro(null, BigDecimal.ZERO, BigDecimal.ONE), 
//						new Filtro(null, BigDecimal.ONE, null)
//				}, 
//				qtdsEsperadas
//				));
//		
//		int qtdAteZero = 0, qtdEntreZeroEUm = 0, qtdMaiorQueUm = 0;
//		
//		for(SimuladoItem item : itens) {
//			if(item.getItem().getDificuldade().compareTo(BigDecimal.ZERO) >= 0 && item.getItem().getDificuldade().compareTo(BigDecimal.ONE) <= 0)
//				qtdEntreZeroEUm++;
//			else if(item.getItem().getDificuldade().compareTo(BigDecimal.ZERO) == -1)
//				qtdAteZero++;
//			else
//				qtdMaiorQueUm++;
//		}
//		
//		Assert.assertEquals((int) qtdsEsperadas[0], qtdAteZero);
//		Assert.assertEquals((int) qtdsEsperadas[1], qtdEntreZeroEUm);
//		Assert.assertEquals((int) qtdsEsperadas[2], qtdMaiorQueUm);
//	}
//	
//	@Test
//	public void deveGerarUmSimuladoComAsFaixasDificuldadesEHabilidadesCorretamente() throws DadosInsuficientesException {
//		List<SimuladoItem> itens = gerador.gerarSimulado(new Distribuicao(
//				new Filtro[] {
//						new Filtro(new Habilidade((byte) 1), null, BigDecimal.ZERO), 
//						new Filtro(new Habilidade((byte) 2), BigDecimal.ZERO, BigDecimal.ONE), 
//						new Filtro(new Habilidade((byte) 3), BigDecimal.valueOf(2), BigDecimal.valueOf(3))
//				}, 
//				new Integer[] {10, 10, 10}
//				));
//		
//		Assert.assertEquals(30, itens.size());
//		
//		for(SimuladoItem item : itens) {
//			switch(item.getItem().getHabilidade().getId()) {
//			case 1: Assert.assertTrue(item.getItem().getDificuldade().compareTo(BigDecimal.ZERO) <= 0); break;
//			case 2: Assert.assertTrue(item.getItem().getDificuldade().compareTo(BigDecimal.ZERO) >= 0 && item.getItem().getDificuldade().compareTo(BigDecimal.ONE) <= 0); break;
//			case 3: Assert.assertTrue(item.getItem().getDificuldade().compareTo(BigDecimal.valueOf(2)) >= 0 && item.getItem().getDificuldade().compareTo(BigDecimal.valueOf(3)) <= 0); break;
//			}
//		}
//	}
//	
//	@Test
//	public void deveGerarUmSimuladoComDiferentesFaixasDeDificuldadeDaMesmaHabilidade() throws DadosInsuficientesException {
//		Integer[] qtdsEsperadas = {7, 3};
//
//		List<SimuladoItem> itens = gerador.gerarSimulado(new Distribuicao(
//				new Filtro[] {
//						new Filtro(new Habilidade((byte) 1), BigDecimal.valueOf(-1), BigDecimal.valueOf(2)), 
//						new Filtro(new Habilidade((byte) 1), BigDecimal.valueOf(2), null)
//				}, 
//				qtdsEsperadas
//				));
//		
//		Assert.assertEquals(10, itens.size());
//		
//		int qtdMenorFaixa = 0, qtdMaiorFaixa = 0;
//		
//		for(SimuladoItem item : itens) {
//			Assert.assertEquals((byte) 1, (byte) item.getItem().getHabilidade().getId());
//			
//			if(item.getItem().getDificuldade().compareTo(BigDecimal.valueOf(-1)) >= 0 && item.getItem().getDificuldade().compareTo(BigDecimal.valueOf(2)) <= 0)
//				qtdMenorFaixa++;
//			else if(item.getItem().getDificuldade().compareTo(BigDecimal.valueOf(2)) >= 0)
//				qtdMaiorFaixa++;
//		}
//		
//		Assert.assertEquals((int) qtdsEsperadas[0], qtdMenorFaixa);
//		Assert.assertEquals((int) qtdsEsperadas[1], qtdMaiorFaixa);
//	}
//	
//}
