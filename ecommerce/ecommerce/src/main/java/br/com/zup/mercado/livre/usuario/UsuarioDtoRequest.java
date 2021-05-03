package br.com.zup.mercado.livre.usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioDtoRequest {

	@NotBlank 
	@Email
	private String login;
	
	@NotBlank @Size(min=6)
	private String senha;

	public UsuarioDtoRequest(@NotBlank @Email String login, @NotBlank @Size(min = 6) String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	} 
	
	/*public UsuarioModel toModel() {
		return new UsuarioModel(passar a senha); 
	}*/  //Ver como faz O SERVICE PARA A SENHA , PARA RETORNAR A SENHA VALIDA! FAZER OS VALIDADORES GENERICOS,VER COMO FAZ A SECURITY !

}
