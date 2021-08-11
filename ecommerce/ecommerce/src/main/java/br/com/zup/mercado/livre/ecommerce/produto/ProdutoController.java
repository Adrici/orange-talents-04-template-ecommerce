package br.com.zup.mercado.livre.ecommerce.produto;

import br.com.zup.mercado.livre.ecommerce.usuario.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private br.com.zup.mercado.livre.ecommerce.usuario.UsuarioRepository UsuarioRepository;

    @InitBinder(value = "produtoRequest")
    public void init(WebDataBinder webDataBinder){
        webDataBinder.addValidators(new ProibeCaracteristicasComNomeIgualValidator());
    }

    @PostMapping
    @Transactional
    public String cadastrarProduto(@RequestBody @Valid ProdutoRequest request) {
        UsuarioModel dono = UsuarioRepository.findByLogin("adriana@email.com").get();
        ProdutoModel produto = request.toModel(manager, dono);
        manager.persist(produto);
        return request.toString();
    }
}
