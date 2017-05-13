package br.com.appvendas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by MarioJ on 18/08/15.
 */
@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	private String inscricaoEstadual;
	private String nomeFantasia;
	private String razaoSocial;
	private Vendedor vendedor;
	private Date dataAlteracao;

	// index to buscar object
	private int index;

	@Column(length = 20)
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "inscricao_estadual", length = 15)
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	@Column(name = "nome_fantasia", length = 100)
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	@Column(name = "razao_social", length = 100)
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@JsonIgnore()
	@ManyToOne
	@JoinColumn(name = "vendedor_id")
	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_alteracao")
	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	@Transient
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {

		return super.toString() + "\nCliente{" + "cnpj='" + cnpj + '\'' + ", inscricaoEstadual='" + inscricaoEstadual + '\'' + ", nomeFantasia='" + nomeFantasia
				+ '\'' + ", razaoSocial='" + razaoSocial + '\'' + ", vendedor=" + vendedor + '}';
	}
}
