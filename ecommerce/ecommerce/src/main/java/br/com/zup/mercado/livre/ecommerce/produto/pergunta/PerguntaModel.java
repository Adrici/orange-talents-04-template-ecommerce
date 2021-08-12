package br.com.zup.mercado.livre.ecommerce.produto.pergunta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.mercado.livre.ecommerce.produto.ProdutoModel;
import br.com.zup.mercado.livre.ecommerce.usuario.UsuarioModel;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
public class PerguntaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotNull
    @CreationTimestamp
    private LocalDateTime instanteCriacao = LocalDateTime.now();
    @ManyToOne
    @NotNull
    private UsuarioModel usuario;
    @ManyToOne
    @NotNull
    private ProdutoModel produto;

    public PerguntaModel(@NotBlank String titulo, @NotNull UsuarioModel usuario, @NotNull ProdutoModel produto) {
        this.titulo = titulo;
        this.usuario = usuario;
        this.produto = produto;
    }

    @Deprecated
    public PerguntaModel() {}

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getInstanteCriacao() {
        return instanteCriacao;
    }

    public UsuarioModel  getUsuario() {
        return usuario;
    }

    public ProdutoModel  getProduto() {
        return produto;
    }

}
