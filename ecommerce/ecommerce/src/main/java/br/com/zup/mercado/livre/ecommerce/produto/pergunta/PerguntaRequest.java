package br.com.zup.mercado.livre.ecommerce.produto.pergunta;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import br.com.zup.mercado.livre.ecommerce.produto.ProdutoModel;
import br.com.zup.mercado.livre.ecommerce.usuario.UsuarioModel;
import com.fasterxml.jackson.annotation.JsonCreator;



public class PerguntaRequest {

    @NotBlank
    private String titulo;

    @JsonCreator
    public PerguntaRequest(@NotBlank String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public PerguntaModel toModel(@NotNull @Valid UsuarioModel usuario, @NotNull @Valid ProdutoModel produto) {
        return new PerguntaModel(titulo, usuario, produto);
    }

}
