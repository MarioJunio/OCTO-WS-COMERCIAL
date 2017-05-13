package br.com.appvendas.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "permissao_vendedor_mobile")
public class PermissaoVendedorMobile implements GrantedAuthority {

	private Long id;
	private Permissao permissao;
	private VendedorMobile vendedorMobile;

	@Transient
	@Override
	public String getAuthority() {
		return permissao.name();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Enumerated(EnumType.STRING)
	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "vendedor_mobile_id")
	public VendedorMobile getVendedorMobile() {
		return vendedorMobile;
	}

	public void setVendedorMobile(VendedorMobile vendedorMobile) {
		this.vendedorMobile = vendedorMobile;
	}

	@Override
	public String toString() {
		return "PermissaoVendedorMobile [id=" + id + ", permissao=" + permissao + "]";
	}

}
