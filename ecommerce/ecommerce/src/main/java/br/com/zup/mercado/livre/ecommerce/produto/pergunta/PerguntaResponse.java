package br.com.zup.mercado.livre.ecommerce.produto.pergunta;

public class PerguntaResponse {

    private Long id;
    private String titulo;

    public PerguntaResponse(PerguntaModel pergunta) {
        this.id = pergunta.getId();
        this.titulo = pergunta.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
