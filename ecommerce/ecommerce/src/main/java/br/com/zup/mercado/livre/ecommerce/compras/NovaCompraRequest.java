package br.com.zup.mercado.livre.ecommerce.compras;

import br.com.zup.mercado.livre.ecommerce.produto.ProdutoModel;
import br.com.zup.mercado.livre.ecommerce.usuario.UsuarioModel;
import br.com.zup.mercado.livre.ecommerce.utils.ExistsId;
import br.com.zup.mercado.livre.ecommerce.utils.GatewayExists;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class NovaCompraRequest {

    @NotNull
    @ExistsId(targetClass = ProdutoModel.class, campo = "id")
    private Long idProduto;

    @NotNull @Positive
    private Integer quantidade;

    @NotNull @GatewayExists
    private String gateway;

    public NovaCompraRequest(Long idProduto, Integer quantidade, String gateway) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.gateway = gateway;
    }

    public CompraModel toModel(ProdutoModel produto, UsuarioModel usuario){
        return new CompraModel(produto, usuario, produto.getValor(), quantidade, GatewayPagamento.valueOf(gateway));
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public String getGateway() {
        return gateway;
    }
}