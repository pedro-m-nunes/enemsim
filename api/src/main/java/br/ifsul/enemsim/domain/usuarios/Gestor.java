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
@DiscriminatorValue("GE")
public class Gestor extends Usuario { // final?
	
	public Gestor(Integer id) {
		super(id);
	}

	public Gestor(String username, String senha, String nome) {
		super(username, senha, nome);
	}
	
	@Override
	public String getPapel() {
		return Gestor.class.getAnnotation(DiscriminatorValue.class).value();
	}

}
