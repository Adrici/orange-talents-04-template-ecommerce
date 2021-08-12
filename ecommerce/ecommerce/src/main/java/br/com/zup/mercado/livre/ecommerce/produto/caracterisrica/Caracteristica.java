package br.com.zup.mercado.livre.ecommerce.produto.caracterisrica;

import br.com.zup.mercado.livre.ecommerce.produto.ProdutoModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;


@Entity
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @ManyToOne
    private ProdutoModel produto;

    public Caracteristica(@NotBlank String nome, @NotBlank String descricao, @Valid ProdutoModel produto) {
        this.nome = nome;
        this.descricao = descricao;
        this.produto = produto;
    }

    @Deprecated
    public Caracteristica() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public ProdutoModel  getProduto() {
        return produto;
    }

}
