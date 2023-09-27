package br.ifsul.enemsim.entidades.relacionais.auxiliar;

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
public class EstudanteHabilidadeId implements Serializable {

	private Integer estudanteId;
	
	private Integer habilidadeId;
	
}
