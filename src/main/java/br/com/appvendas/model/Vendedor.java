package br.com.appvendas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vendedor")
@PrimaryKeyJoinColumn
public class Vendedor extends Pessoa {

	private float comissao;
	private VendedorMobile vendedorMobile;

	@Column(precision = 10, scale = 2)
	public float getComissao() {
		return comissao;
	}

	public void setComissao(float comissao) {
		this.comissao = comissao;
	}

	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vendedor_mobile_id")
	public VendedorMobile getVendedorMobile() {
		return vendedorMobile;
	}

	public void setVendedorMobile(VendedorMobile vendedorMobile) {
		this.vendedorMobile = vendedorMobile;
	}

	@Override
	public String toString() {
		return "Vendedor [comissao=" + comissao + ", vendedorMobile=" + vendedorMobile + "]";
	}
	
}
