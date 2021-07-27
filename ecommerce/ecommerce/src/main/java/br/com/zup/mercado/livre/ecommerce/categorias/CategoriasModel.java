package br.com.zup.mercado.livre.ecommerce.categorias;

import br.com.zup.mercado.livre.ecommerce.usuario.UsuarioModel;
import br.com.zup.mercado.livre.ecommerce.utils.UniqueValue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class CategoriasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @UniqueValue(domainClass = CategoriasModel.class, fieldName = "nome", message = "Esta categoria já existe no sistema!")
    private String nome;

    public CategoriasModel(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Deprecated
    public CategoriasModel() {}
}


