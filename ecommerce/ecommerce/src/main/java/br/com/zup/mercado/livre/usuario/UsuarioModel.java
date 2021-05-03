package br.com.zup.mercado.livre.usuario;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import com.sun.istack.NotNull;

@Entity
public class UsuarioModel {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank 
	@Email
	private String login;
	
	@NotBlank @Size(min=6)
	private String senha; 
	
	@NotNull 
	@CreationTimestamp // Anotação do Hibernate - utilizada para especificar que o tipo temporal atualmente anotado deve ser inicializado com o valor de registro de data e hora da JVM atual.
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	
	@Deprecated
	public UsuarioModel() {
		 
	}


	public UsuarioModel(Long id, @NotBlank @Email String login, @NotBlank @Size(min = 6) String senha,
			LocalDateTime dataCadastro) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.dataCadastro = dataCadastro;
	}


	public Long getId() {
		return id;
	}


	public String getLogin() {
		return login;
	}


	public String getSenha() {
		return senha;
	}


	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	
		
}


/*
 * precisamos saber o instante do cadastro, login e senha. ok
> Restrições:
O instante não pode ser nulo e não pode ser no futuro - ok 
O login não pode ser em branco ou nula - ok 
O login precisa ter o formato do email - ok 
A senha não pode ser branca ou nula - ok 
A senha precisa ter no mínimo 6 caracteres - ok 

------------------------------------------------------------
A senha deve ser guardada usando algum algoritmo de hash da sua escolha.
----------------------------------------------------------------------------
Resultado esperado
O usuário precisa estar criado no sistema
O cliente que fez a requisição precisa saber que o usuário foi criado. 
Apenas um retorno com status 200 está suficente.
Em caso de falha de validação status 400
 * 
 * 
 * 
 * */
