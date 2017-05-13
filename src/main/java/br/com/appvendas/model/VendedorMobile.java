package br.com.appvendas.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "vendedor_mobile")
public class VendedorMobile implements UserDetails, Serializable {

	private Long id;
	private String usuario;
	private String senha;
	private String tmpSenha;
	private boolean ativo;
	private int tentativasLogin;
	private Vendedor vendedor;
	private List<PermissaoVendedorMobile> permissoes;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length = 40, unique = true)
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(length = 32)
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Transient
	public String getTmpSenha() {
		return tmpSenha;
	}

	public void setTmpSenha(String tmpSenha) {
		this.tmpSenha = tmpSenha;
	}

	@Column
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Column(name = "tentativas_login")
	public int getTentativasLogin() {
		return tentativasLogin;
	}

	public void setTentativasLogin(int tentativasLogin) {
		this.tentativasLogin = tentativasLogin;
	}

	@OneToOne(mappedBy = "vendedorMobile")
	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	@OneToMany(mappedBy = "vendedorMobile", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	public List<PermissaoVendedorMobile> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<PermissaoVendedorMobile> permissoes) {
		this.permissoes = permissoes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		VendedorMobile that = (VendedorMobile) o;

		return id != null ? id.equals(that.id) : that.id == null;

	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "VendedorMobile{" + "id=" + id + ", usuario='" + usuario + '\'' + ", senha='" + senha + '\''
				+ ", tmpSenha='" + tmpSenha + '\'' + ", ativo=" + ativo + ", tentativasLogin=" + tentativasLogin + '}';
	}

	@Transient
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return permissoes;
	}

	@Transient
	@Override
	public String getPassword() {
		return senha;
	}

	@Transient
	@Override
	public String getUsername() {
		return usuario;
	}

	@Transient
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Transient
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Transient
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Transient
	@Override
	public boolean isEnabled() {
		return ativo;
	}
}
