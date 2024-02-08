package mz.cm.api.produtos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mz.cm.api.produtos.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends CrudRepository<ProdutoModel, Long> {
	

}
