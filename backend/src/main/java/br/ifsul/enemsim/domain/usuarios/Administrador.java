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
@DiscriminatorValue("ADM")
public class Administrador extends Usuario { // final?
	
//	@Transient
//	public static String getDiscriminatorValue() { // ?
//	    return Administrador.class.getAnnotation(DiscriminatorValue.class).value();
//	}
	
	public Administrador(Integer id) {
		super(id);
	}

	public Administrador(String username, String senha, String nome) {
		super(username, senha, nome);
	}

}
