package br.com.zup.mercado.livre.usuario;


public class UsuarioDtoResponse {
	
	private String login;
	private String senha;
	
	public UsuarioDtoResponse(UsuarioModel usuario) {
		super();
		this.login = usuario.getLogin();
		this.senha = usuario.getSenha();
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	} 

	
}
