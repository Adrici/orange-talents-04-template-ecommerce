package br.com.zup.mercado.livre.ecommerce.usuario;

import io.jsonwebtoken.lang.Assert;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotBlank;

public class Senha {

    private String senha;

    public Senha(@NotBlank @Length(min = 6) String senha) {
        Assert.hasLength(senha, "senha não pode ser em branco");
        Assert.isTrue(senha.length() >= 6, "senha tem que ter no mínimo 6 caracteres");
        this.senha = senha;
    }

    public String hash() {
        return new BCryptPasswordEncoder().encode(senha);
    }
}