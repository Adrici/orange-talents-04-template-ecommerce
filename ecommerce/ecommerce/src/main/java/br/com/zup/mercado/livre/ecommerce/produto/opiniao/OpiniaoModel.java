package br.com.zup.mercado.livre.ecommerce.produto.opiniao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import br.com.zup.mercado.livre.ecommerce.produto.ProdutoModel;
import br.com.zup.mercado.livre.ecommerce.usuario.UsuarioModel;
import org.hibernate.validator.constraints.Range;



@Entity
public class OpiniaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Range(min = 1, max = 5)
    private Integer nota;
    @NotBlank
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String descricao;
    @NotNull
    @ManyToOne
    private UsuarioModel usuario;
    @NotNull
    @ManyToOne
    private ProdutoModel produto;

    public OpiniaoModel(@NotNull @Range(min = 1, max = 5) Integer nota, @NotBlank String titulo,
                   @NotBlank @Size(max = 5000) String descricao, @NotNull UsuarioModel  usuario, @NotNull ProdutoModel produto) {
        this.nota = nota;
        this.titulo = titulo;
        this.descricao = descricao;
        this.usuario = usuario;
        this.produto = produto;
    }

    @Deprecated
    public OpiniaoModel() {
    }

    public Long getId() {
        return id;
    }

    public Integer getNota() {
        return nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

}