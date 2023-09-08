package br.ifsul.enemsim.gerador;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.exceptions.DistribuicaoException;

public class DistribuicaoTest {
	
	@Test
	public void deveCriarUmaDistribuicaoCorretamente() throws DistribuicaoException {
		Distribuicao distribuicao = new Distribuicao(
				new Filtro[] {new Filtro(new Habilidade((byte) 1), null, null), new Filtro(null, null, BigDecimal.ZERO)}, 
				new Integer[] {5, 5}
				);
		
		Assert.assertNotNull(distribuicao);
		Assert.assertEquals(2, distribuicao.size());
	}
	
//	@Test
//	public void deveJogarUmaExcecaoQuandoOsVetoresDeDistribuicaoNaoTemTamanhosIguais() {		
//		Assertions.assertThrows(IllegalArgumentException.class, () -> {
//			new Distribuicao(new Filtro[] {new Filtro(null, null, null)}, new Integer[] {3, 7, 9});
//		});
//		
//		Assertions.assertThrows(IllegalArgumentException.class, () -> {
//			new Distribuicao(new Filtro[] {new Filtro(null, null, null), new Filtro(null, null, null)}, new Integer[] {3});
//		});
//	}
//	
//	@Test
//	public void deveJogarUmaExcecaoQuandoAlgumVetorPossuirTamanho0() {
//		Assertions.assertThrows(IllegalArgumentException.class, () -> {
//			new Distribuicao(new Filtro[0], new Integer[0]);
//		});
//		
//		Assertions.assertThrows(IllegalArgumentException.class, () -> {
//			new Distribuicao(new Filtro[] {new Filtro(null, null, null)}, new Integer[0]);
//		});
//		
//		Assertions.assertThrows(IllegalArgumentException.class, () -> {
//			new Distribuicao(new Filtro[0], new Integer[] {1, 2, 3});
//		});
//	}
//	
//	@Test
//	public void deveJogarUmaExcecaoQuandoAlgumVetorPossuirUmItemNulo() {
//		Assertions.assertThrows(IllegalArgumentException.class, () -> {
//			new Distribuicao(new Filtro[4], new Integer[4]);
//		});
//		
//		Assertions.assertThrows(IllegalArgumentException.class, () -> {
//			new Distribuicao(new Filtro[] {new Filtro(null, null, null)}, new Integer[1]);
//		});
//		
//		Assertions.assertThrows(IllegalArgumentException.class, () -> {
//			new Distribuicao(new Filtro[3], new Integer[] {1, 2, 3});
//		});
//	}
	
}
