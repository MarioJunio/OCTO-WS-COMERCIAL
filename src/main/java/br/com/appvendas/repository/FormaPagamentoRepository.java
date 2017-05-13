package br.com.appvendas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.appvendas.model.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {

	@Query("from FormaPagamento a where a.dataAlteracao > :data_alteracao")
	public List<FormaPagamento> buscarPorDataAlteracao(@Param("data_alteracao") Date dataAlteracao);
}
