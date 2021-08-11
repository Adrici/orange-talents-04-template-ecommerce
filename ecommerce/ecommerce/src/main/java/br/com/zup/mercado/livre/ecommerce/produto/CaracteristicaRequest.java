package br.com.zup.mercado.livre.ecommerce.produto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import com.sun.istack.NotNull;


public class CaracteristicaRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;

    public CaracteristicaRequest(@NotBlank String nome, @NotBlank String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "ProdutoRequest{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public Caracteristica toModel(@NotNull @Valid ProdutoModel produto) {
        return new Caracteristica(nome, descricao, produto);
    }

}