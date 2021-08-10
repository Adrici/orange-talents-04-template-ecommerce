package br.com.zup.mercado.livre.ecommerce.categorias;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import br.com.zup.mercado.livre.ecommerce.utils.ExistsValue;
import br.com.zup.mercado.livre.ecommerce.utils.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;


public class CategoriaRequest {
    @NotBlank
    @UniqueValue(domainClass = CategoriaModel.class, fieldName = "nome", message = "Já existe uma categoria com esse nome")
    private String nome;

    @ExistsValue(domainClass = CategoriaModel.class, fieldName = "id", required = false, message = "Categoria mãe não existe")
    private Long categoriaId;

    @JsonCreator
    public CategoriaRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public CategoriaRequest(@NotBlank String nome, Long categoriaId) {
        this.nome = nome;
        this.categoriaId = categoriaId;
    }

    public String getNome() {
        return nome;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public CategoriaModel toModel(EntityManager manager) {
        CategoriaModel categoria = new CategoriaModel(nome);
        if(categoriaId != null) {
            categoria.setCategoria(manager.find(CategoriaModel.class, categoriaId));
        }
        return categoria;
    }
}