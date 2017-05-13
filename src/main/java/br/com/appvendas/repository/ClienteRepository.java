package br.com.appvendas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.appvendas.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query("select a from Cliente a join a.vendedor b where b.id = :vendedor_id and a.dataAlteracao > :data_alteracao")
	public List<Cliente> buscarPorDataAltracao(@Param("vendedor_id") Long id, @Param("data_alteracao") Date dataAlteracao);

}
