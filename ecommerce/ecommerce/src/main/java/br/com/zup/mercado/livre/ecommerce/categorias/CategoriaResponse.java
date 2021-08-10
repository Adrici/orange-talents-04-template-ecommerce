package br.com.zup.mercado.livre.ecommerce.categorias;

public class CategoriaResponse {

    private Long id;
    private String nome;

    public CategoriaResponse(CategoriaModel categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
