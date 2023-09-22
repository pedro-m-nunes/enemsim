package br.ifsul.enemsim.entidades.usuarios;

import br.ifsul.enemsim.entidades.Usuario;
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
@DiscriminatorValue("PROF")
public class Professor extends Usuario { // final?
	
//	@Transient
//	public static String getDiscriminatorValue() { // ?
//	    return Professor.class.getAnnotation(DiscriminatorValue.class).value();
//	}
	
	public Professor(Integer id) {
		super(id);
	}

	public Professor(String username, String senha, String nome) {
		super(username, senha, nome);
	}

}
