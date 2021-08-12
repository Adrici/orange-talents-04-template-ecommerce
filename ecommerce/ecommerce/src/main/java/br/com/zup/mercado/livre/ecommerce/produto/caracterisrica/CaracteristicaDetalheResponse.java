package br.com.zup.mercado.livre.ecommerce.produto.caracterisrica;

public class CaracteristicaDetalheResponse {

    private String nome;
    private String descricao;

    public CaracteristicaDetalheResponse(Caracteristica caracteristica) {
        this.nome = caracteristica.getNome();
        this.descricao = caracteristica.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

}