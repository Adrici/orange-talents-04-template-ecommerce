package br.com.zup.mercado.livre.ecommerce.compras;

import br.com.zup.mercado.livre.ecommerce.produto.ProdutoModel;
import br.com.zup.mercado.livre.ecommerce.produto.ProdutoRepository;
import br.com.zup.mercado.livre.ecommerce.usuario.UsuarioModel;
import br.com.zup.mercado.livre.ecommerce.utils.email.Mailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.util.UriComponentsBuilder;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/produtos/compras")
public class CompraController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private Mailer mailer;

    @PostMapping
    @Transactional
    public String realizarCompra(@RequestBody @Valid NovaCompraRequest novaCompraRequest,
                                 @AuthenticationPrincipal UsuarioModel usuario, UriComponentsBuilder uriComponentsBuilder){

        ProdutoModel produto = produtoRepository.findById(novaCompraRequest.getIdProduto()).get();

        CompraModel novaCompra = novaCompraRequest.toModel(produto, usuario);
        compraRepository.save(novaCompra);
        produtoRepository.save(produto);
        

        String urlRetorno = uriComponentsBuilder.path("/" + novaCompraRequest.getGateway().toString().toLowerCase()+"/id")
                .build(novaCompra.getId()).toString();

        return novaCompraRequest.getGateway().toString().toLowerCase()+".com/" + novaCompra.getId()+"?redirect="+urlRetorno;

    }
}