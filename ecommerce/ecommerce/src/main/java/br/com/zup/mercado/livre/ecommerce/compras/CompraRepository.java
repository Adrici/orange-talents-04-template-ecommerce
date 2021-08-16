package br.com.zup.mercado.livre.ecommerce.compras;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends CrudRepository<CompraModel, Long> {
}
