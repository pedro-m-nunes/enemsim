package br.ifsul.enemsim.domain.usuarios;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // precisa? nome de usuário como id?
	
	@NotBlank
	@Size(min = 6, max = 20, message = "O nome de usuário deve ter pelo menos 6 caracteres e no máximo 20.") // max? max e min como constantes?
	@Column(nullable = false, unique = true)
	private String username;
	
	@NotBlank
	@Size(min = 6, max = 60, message = "A senha deve ter pelo menos 6 caracteres e no máximo 60.") // max? max e min como constantes?
	@Column(nullable = false)
	private String senha; // criptografar...
	
	@Pattern(regexp = "^(?=\\s*\\S).*$") // Não pode ser vazio, mas pode ser nulo.
	private String nome; // ? // nome e sobrenome?
	
	// tipo?
	
	// foto? por ora, não
	
	// instituição?
	
	// ativo, dataCriacao, dataDesativacao
	
	protected Usuario(String username, String senha, String nome) {
		super();
		this.username = username;
		this.senha = senha;
		this.nome = nome;
	}

	protected Usuario(Integer id) {
		super();
		this.id = id;
	}
	
}
