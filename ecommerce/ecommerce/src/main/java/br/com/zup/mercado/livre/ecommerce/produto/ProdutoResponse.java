package br.com.zup.mercado.livre.ecommerce.produto;

public class ProdutoResponse {
    private Long id;

    private String nome;

    public ProdutoResponse(ProdutoModel produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
