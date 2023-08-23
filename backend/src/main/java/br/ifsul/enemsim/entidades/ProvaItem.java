package br.ifsul.enemsim.entidades;

import br.ifsul.enemsim.entidades.auxiliar.ProvaItemId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
public class ProvaItem {

	@EmbeddedId // @IdClass?
	private ProvaItemId id;
	
	@ManyToOne // cascade?
	@MapsId("provaId")
	@JoinColumn(nullable = false)
	private Prova prova;
	
	@ManyToOne
	@MapsId("itemId")
	@JoinColumn(nullable = false)
	private Item item;
	
	@Column(nullable = false)
	private Short numero; // ""?

	public ProvaItem(Prova prova, Item item, Short numero) {
		super();
		this.prova = prova;
		this.item = item;
		this.numero = numero;
	}

	public ProvaItem(ProvaItemId id, Short numero) {
		super();
		this.id = id;
		this.numero = numero;
	}
	
	public ProvaItem(Integer provaId, Integer itemId, Short numero) {
		super();
		this.id = new ProvaItemId(provaId, itemId);
		this.numero = numero;
	}
	
}
