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
@DiscriminatorValue("ADM")
public class Administrador extends Usuario { // final?
	
//	@Transient
//	public static String getDiscriminatorValue() { // ?
//	    DiscriminatorValue value = Administrador.class.getAnnotation(DiscriminatorValue.class);
//	    return value.value();
//	}
	
	public Administrador(Integer id) {
		super(id);
	}

	public Administrador(String username, String senha, String nome) {
		super(username, senha, nome);
	}

}
