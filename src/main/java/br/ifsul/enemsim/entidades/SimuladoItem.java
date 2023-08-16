package br.ifsul.enemsim.entidades;

import br.ifsul.enemsim.entidades.auxiliar.SimuladoItemId;
import br.ifsul.enemsim.enums.Resposta;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder // só para testes?
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor // ?
@EqualsAndHashCode // considerar id?
@Entity
public class SimuladoItem {
	
	@EmbeddedId
	private SimuladoItemId id; // @IdClass?
	
	@ManyToOne // cascade?
	@MapsId("simuladoId")
	private Simulado simulado;
	
	@ManyToOne // cascade?
	@MapsId("itemId")
	private Item item;
	
	@Enumerated(EnumType.STRING) // nullable
	private Resposta resposta;
	
	public SimuladoItem(Simulado simulado, Item item) { // ?
		super();
		this.id = new SimuladoItemId();
		this.simulado = simulado;
		this.item = item;
		this.resposta = null; // ?
	}
	
}
