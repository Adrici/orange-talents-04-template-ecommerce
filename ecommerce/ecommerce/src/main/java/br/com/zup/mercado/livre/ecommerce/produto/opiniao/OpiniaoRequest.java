package br.com.zup.mercado.livre.ecommerce.produto.opiniao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zup.mercado.livre.ecommerce.produto.ProdutoModel;
import br.com.zup.mercado.livre.ecommerce.usuario.UsuarioModel;
import org.hibernate.validator.constraints.Range;

public class OpiniaoRequest {

    @NotNull
    @Range(min = 1, max = 5)
    private Integer nota;
    @NotBlank
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String descricao;

    public OpiniaoRequest(@NotNull @Range(min = 1, max = 5) Integer nota, @NotBlank String titulo,
                          @NotBlank @Size(max = 5000) String descricao) {
        this.nota = nota;
        this.titulo = titulo;
        this.descricao = descricao;
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

    public OpiniaoModel toModel(UsuarioModel usuarioLogado, ProdutoModel produto) {
        return new OpiniaoModel(nota, titulo, descricao, usuarioLogado, produto);
    }

}
