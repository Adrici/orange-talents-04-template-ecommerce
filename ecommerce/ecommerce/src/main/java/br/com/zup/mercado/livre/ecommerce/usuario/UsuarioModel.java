package br.com.zup.mercado.livre.ecommerce.usuario;

import io.jsonwebtoken.lang.Assert;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.util.StringUtils;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class UsuarioModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Email
    private String login;
    @NotBlank @Size(min = 6)
    private String senha;
    @NotNull @CreationTimestamp
    private LocalDateTime instanteCadastro = LocalDateTime.now();


    public UsuarioModel(@NotBlank @Email String login, @NotNull @Valid Senha senhaLimpa) {
        Assert.isTrue(StringUtils.hasLength(login), "Login @NotBlank");
        Assert.notNull(senhaLimpa, "A senha não pode ser nula ");
        this.login = login;
        this.senha = senhaLimpa.hash();
    }

    @Deprecated
    public UsuarioModel() {}
}
