package br.ifsul.enemsim.entidades;

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
import jakarta.validation.constraints.NotNull;
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
@DiscriminatorColumn(name = "tipo_usuario", discriminatorType = DiscriminatorType.STRING) // char?
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // precisa? nome de usuário como id?
	
	@NotNull
	@NotBlank
	@Size(min = 6, message = "O nome de usuário deve ter pelo menos 6 caracteres.") // max?
	@Column(nullable = false, unique = true)
	private String username; // ""? "login"?
	
	@NotNull
	@NotBlank
	@Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres.") // max?
	@Column(nullable = false)
	private String senha; // criptografar...
	
	@NotBlank
	private String nome; // ? // nome e sobrenome?
	
	// foto? por ora, não
	
	// instituição?
	
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
