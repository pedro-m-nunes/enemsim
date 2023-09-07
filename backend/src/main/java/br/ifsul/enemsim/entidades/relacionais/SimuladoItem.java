package br.ifsul.enemsim.entidades.relacionais;

import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Simulado;
import br.ifsul.enemsim.entidades.auxiliar.Resposta;
import br.ifsul.enemsim.entidades.relacionais.auxiliar.SimuladoItemId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class SimuladoItem {
	
	@EmbeddedId // @IdClass?
	private SimuladoItemId id;
	
	@ManyToOne // cascade? quando se cria um SimuladoItem, deve criar um Simulado. quando se apaga um Simulado, deve apagar os SimuladoItens associados. // cascade "reverso"?
	@MapsId("simuladoId")
	@JoinColumn(nullable = false)
	private Simulado simulado;
	
	@ManyToOne
	@MapsId("itemId")
	@JoinColumn(nullable = false)
	private Item item;
	
	@Enumerated(EnumType.STRING)
	private Resposta resposta;
	
	public SimuladoItem(Simulado simulado, Item item) {
		super();
		this.id = new SimuladoItemId();
		this.simulado = simulado;
		this.item = item;
	}
	
	public SimuladoItem(SimuladoItemId id) {
		super();
		this.id = id;
	}

	public SimuladoItem(Integer simuladoId, Integer itemId) {
		super();
		this.id = new SimuladoItemId(simuladoId, itemId);
	}

}
