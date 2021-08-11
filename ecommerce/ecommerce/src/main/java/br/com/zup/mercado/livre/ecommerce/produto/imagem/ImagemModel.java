package br.com.zup.mercado.livre.ecommerce.produto.imagem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.mercado.livre.ecommerce.produto.ProdutoModel;
import org.hibernate.validator.constraints.URL;

@Entity
public class ImagemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @URL
    private String link;

    @ManyToOne
    @NotNull
    @Valid
    private ProdutoModel produto;

    public ImagemModel(@NotNull @Valid ProdutoModel produto, @URL @NotBlank String link) {
        this.produto = produto;
        this.link = link;
    }

    @Deprecated
    public ImagemModel() {

    }

    public Long getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public ProdutoModel  getProduto() {
        return produto;
    }

    @Override
    public String toString() {
        return "ImagemProduto{" +
                "id=" + id +
                ", link='" + link + '\'' +
                '}';
    }
}