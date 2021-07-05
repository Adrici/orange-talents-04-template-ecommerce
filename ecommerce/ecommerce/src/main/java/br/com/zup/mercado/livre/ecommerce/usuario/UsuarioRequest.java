package br.com.zup.mercado.livre.ecommerce.usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioRequest {

    @NotBlank
    @Email
    private String login;
    @NotBlank
    @Size(min = 6)
    private String senha;

    public UsuarioRequest(@NotBlank @Email String login, @NotBlank @Size(min = 6) String senha) {
        super();
        this.login = login;
        this.senha = senha;
    }

    public UsuarioModel toModel() {
        return new UsuarioModel(login, new Senha(senha));
    }
}