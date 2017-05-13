package br.com.appvendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.appvendas.model.VendedorMobile;

public interface VendedorMobileRepository extends JpaRepository<VendedorMobile, Long> {

	public VendedorMobile findByUsuario(String username);
	
	@Query("FROM VendedorMobile a LEFT JOIN a.permissoes WHERE a.usuario = :usuario AND a.senha = :senha")
	public VendedorMobile entrar(@Param("usuario") String usuario, @Param("senha") String senha);

}
