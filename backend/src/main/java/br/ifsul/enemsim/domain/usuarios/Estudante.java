package br.ifsul.enemsim.domain.usuarios;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("EST")
public class Estudante extends Usuario /*implements ...?*/ { // final?
	
	// simulados? para poder usar cascade...
	
	// atributos...
	
	public Estudante(Integer id) {
		super(id);
	}

	public Estudante(String username, String senha, String nome) {
		super(username, senha, nome);
	}
	
	@Override
	public String getPapel() {
		return Estudante.class.getAnnotation(DiscriminatorValue.class).value();
	}

}
