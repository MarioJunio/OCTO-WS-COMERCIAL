package br.com.appvendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.appvendas.model.ParametroSistema;

public interface ParametroSistemaRepository extends JpaRepository<ParametroSistema, Long> {
	
	@Query("SELECT A FROM ParametroSistema A WHERE A.id = :id")
	public ParametroSistema buscarParametro(@Param("id") Long id);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE ParametroSistema SET valor = :valor WHERE id = :id")
	public void atualizarParametro(@Param("id") Long id, @Param("valor") String valor);
}
