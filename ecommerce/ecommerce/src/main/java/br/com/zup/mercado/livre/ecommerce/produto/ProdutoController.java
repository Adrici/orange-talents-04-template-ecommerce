package br.com.zup.mercado.livre.ecommerce.produto;

import br.com.zup.mercado.livre.ecommerce.produto.imagem.ImagemRequest;
import br.com.zup.mercado.livre.ecommerce.produto.imagem.Uploader;
import br.com.zup.mercado.livre.ecommerce.produto.opiniao.OpiniaoModel;
import br.com.zup.mercado.livre.ecommerce.produto.opiniao.OpiniaoRequest;
import br.com.zup.mercado.livre.ecommerce.produto.opiniao.OpiniaoResponse;
import br.com.zup.mercado.livre.ecommerce.usuario.UsuarioModel;
import br.com.zup.mercado.livre.ecommerce.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private Uploader uploaderFake;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @InitBinder(value = "produtoRequest")
    public void init(WebDataBinder webDataBinder){
        webDataBinder.addValidators(new ProibeCaracteristicasComNomeIgualValidator());
    }

    @PostMapping
    @Transactional
    public String cadastrarProduto(@RequestBody @Valid ProdutoRequest request) {
        UsuarioModel dono = usuarioRepository.findByLogin("adriana@email.com").get();
        ProdutoModel produto = request.toModel(manager, dono);
        manager.persist(produto);
        return request.toString();
    }

    @PostMapping(value = "/{id}/imagens")
    @Transactional
    public void cadastrarImagens(@PathVariable Long id, @Valid ImagemRequest request) {
        /**
         * 1) enviar imagens para o local onde elas vão ficar
         * 2) pegar os links de todas as imagens
         * 3) associar esses links com o produto em questão
         * 4) carregar o produto
         * 5) depois que associar, preciso atualizar a nova versão do produto
         */
        UsuarioModel dono = usuarioRepository.findByLogin("adriana@email.com").get();
        ProdutoModel produto = manager.find(ProdutoModel.class, id);

        if(!produto.pertenceAoUsuario(dono)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Usuário não pode modificar um produto que não seja seu!");
        }

        Set<String> links = uploaderFake.envia(request.getImagens());
        produto.associaImagens(links);
        manager.merge(produto);
    }
    @PostMapping(value = "/{id}/opiniao")
    @Transactional
    public ResponseEntity<OpiniaoResponse> adicionarOpiniao(@PathVariable Long id, @RequestBody @Valid OpiniaoRequest request) {
        UsuarioModel usuarioLogado = usuarioRepository.findByLogin("jonathan@email.com").get();
        ProdutoModel produto = manager.find(ProdutoModel.class, id);
        OpiniaoModel opiniao = request.toModel(usuarioLogado, produto);
        manager.persist(opiniao);

        return ResponseEntity.ok(new OpiniaoResponse(opiniao));
    }

}
