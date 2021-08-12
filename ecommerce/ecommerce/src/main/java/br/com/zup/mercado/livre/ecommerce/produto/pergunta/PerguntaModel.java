package br.com.zup.mercado.livre.ecommerce.produto.pergunta;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import br.com.zup.mercado.livre.ecommerce.produto.ProdutoModel;
import br.com.zup.mercado.livre.ecommerce.usuario.UsuarioModel;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class PerguntaModel implements Comparable<PerguntaModel>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotNull
    @CreationTimestamp
    private LocalDateTime instanteCriacao = LocalDateTime.now();
    @ManyToOne
    @NotNull
    private UsuarioModel usuario;
    @ManyToOne
    @NotNull
    private ProdutoModel produto;

    public PerguntaModel(@NotBlank String titulo, @NotNull UsuarioModel usuario, @NotNull ProdutoModel produto) {
        this.titulo = titulo;
        this.usuario = usuario;
        this.produto = produto;
    }

    @Deprecated
    public PerguntaModel() {}

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getInstanteCriacao() {
        return instanteCriacao;
    }

    public UsuarioModel  getUsuario() {
        return usuario;
    }

    public ProdutoModel getProduto() {
        return produto;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((usuario == null) ? 0 : usuario.hashCode());
        result = prime * result + ((produto == null) ? 0 : produto.hashCode());
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PerguntaModel other = (PerguntaModel) obj;
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        if (produto == null) {
            if (other.produto != null)
                return false;
        } else if (!produto.equals(other.produto))
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        return true;
    }

    @Override
    public int compareTo(PerguntaModel o) {
        return this.titulo.compareTo(o.titulo);
    }

}