package br.ifsul.enemsim.entidades;

import br.ifsul.enemsim.entidades.auxiliar.SimuladoItemId;
import br.ifsul.enemsim.enums.Resposta;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder // só para testes?
@Getter
@Setter
@NoArgsConstructor // ?
@AllArgsConstructor // ?
//@EqualsAndHashCode // precisa, é usado em um Set // considerar id?
@Entity
public class SimuladoItem {

	@EmbeddedId
	private SimuladoItemId id;
	
	@ManyToOne // cascade?
	@MapsId("simuladoId") //
//	@JsonIgnore // JsonView?
	private Simulado simulado; // sem equals...?
	
	@ManyToOne // cascade?
	@MapsId("itemId") //
//	@JsonIgnore // JsonView?
	private Item item;
	
	@Enumerated(EnumType.STRING) // nullable
	private Resposta resposta;

//	@Override
//	public boolean equals(Object obj) { // ?
//		if(this == obj)
//			return true;
//		if(obj == null)
//			return false;
//		if(getClass() != obj.getClass())
//			return false;
//		
//		SimuladoItem other = (SimuladoItem) obj;
//		
//		return Objects.equals(id, other.id) && Objects.equals(item, other.item) && resposta == other.resposta && Objects.equals(simulado.getId(), other.simulado.getId());
//		// usa só o id de simulado // e se simulado = null?
//	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, item, resposta, simulado);
//	}
	
	
}
