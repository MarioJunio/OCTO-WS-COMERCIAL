package br.com.appvendas.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.appvendas.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	
}
