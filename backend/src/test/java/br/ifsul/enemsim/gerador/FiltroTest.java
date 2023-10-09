package br.ifsul.enemsim.gerador;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.services.auxiliar.Filtro;

public class FiltroTest {

	@Test
	public void deveCriarUmFiltroComOsValoresMinimoEMaximoPadraoQuandoInformadosNulos() {
		Filtro filtro = new Filtro(new Habilidade((byte) 1), null, null);
		
		Assert.assertNotNull(filtro);
		
		Assert.assertNotNull(filtro.getDificuldadeMin());
		Assert.assertNotNull(filtro.getDificuldadeMax());
	}
	
}
