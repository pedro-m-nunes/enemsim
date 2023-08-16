package br.ifsul.enemsim.entidades.auxiliar;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SimuladoItemId implements Serializable {

	// not null?
	private Integer simuladoId;
	
	// not null?
	private Integer itemId;
	
}
