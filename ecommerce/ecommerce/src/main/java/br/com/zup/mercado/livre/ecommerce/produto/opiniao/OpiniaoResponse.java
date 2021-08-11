package br.com.zup.mercado.livre.ecommerce.produto.opiniao;

public class OpiniaoResponse {

    private Long id;
    private String titulo;

    public OpiniaoResponse(OpiniaoModel opiniao) {
        this.id = opiniao.getId();
        this.titulo = opiniao.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

}