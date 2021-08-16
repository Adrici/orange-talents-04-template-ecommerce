package br.com.zup.mercado.livre.ecommerce.compras;

import br.com.zup.mercado.livre.ecommerce.produto.ProdutoModel;
import br.com.zup.mercado.livre.ecommerce.usuario.UsuarioModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class CompraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ProdutoModel produto;

    @ManyToOne
    private UsuarioModel usuario;

    @NotNull @Positive
    private BigDecimal valorDoProduto;

    @NotNull @Positive
    private Integer quantidade;

    @Enumerated(EnumType.STRING)
    @NotNull
    private GatewayPagamento gateway;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status = Status.INICIADA;

    public CompraModel(ProdutoModel produto, UsuarioModel usuario, BigDecimal valorDoProduto, Integer quantidade, GatewayPagamento gateway) {
        this.produto = produto;
        this.usuario = usuario;
        this.valorDoProduto = valorDoProduto;
        this.quantidade = quantidade;
        this.gateway = gateway;
    }

    public Long getId() {
        return id;
    }
}