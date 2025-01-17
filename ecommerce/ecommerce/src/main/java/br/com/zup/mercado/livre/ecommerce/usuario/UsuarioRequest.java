package br.com.zup.mercado.livre.ecommerce.usuario;

import br.com.zup.mercado.livre.ecommerce.utils.UniqueValue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioRequest {
    @NotBlank
    @Email
    @UniqueValue(domainClass = UsuarioModel.class, fieldName = "login", message = "Este usuário já existe!")
    private String login;
    @NotBlank
    @Size(min = 6)
    private String senha;

    public UsuarioRequest(@NotBlank @Email String login, @NotBlank @Size(min = 6) String senha) {
        this.login = login;
        this.senha = senha;
    }

    public UsuarioModel toModel() {
        return new UsuarioModel(login, new Senha(senha));
    }

}