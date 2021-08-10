package br.com.zup.mercado.livre.ecommerce.categorias;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaResponse> cadastrarCategoria(@RequestBody @Valid CategoriaRequest request) {
        CategoriaModel categoria = request.toModel(manager);
        manager.persist(categoria);
        return ResponseEntity.ok(new CategoriaResponse(categoria));
    }
}
