package br.com.appvendas.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Created by MarioJ on 28/08/16.
 */
@Entity
@Table(name = "Forma_Pagamento")
public class FormaPagamento implements Serializable {

	private static final long serialVersionUID = -5652796562392059357L;

	private Long id;
	private TipoPagamento tipoPagamento;
	private String descricao;
	private int numeroMaxParcelas;
	private boolean chequePredatado;
	private int prazo;
	private boolean entrada;
	private Date dataAlteracao;

	public FormaPagamento() {
	}

	public FormaPagamento(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pagamento")
	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	@Column
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "numero_max_parcelas")
	public int getNumeroMaxParcelas() {
		return numeroMaxParcelas;
	}

	public void setNumeroMaxParcelas(int numeroMaxParcelas) {
		this.numeroMaxParcelas = numeroMaxParcelas;
	}

	@Column(name = "cheque_predatado")
	public boolean isChequePredatado() {
		return chequePredatado;
	}

	public void setChequePredatado(boolean chequePredatado) {
		this.chequePredatado = chequePredatado;
	}

	@Column
	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	@Column
	public boolean isEntrada() {
		return entrada;
	}

	public void setEntrada(boolean entrada) {
		this.entrada = entrada;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_alteracao")
	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		FormaPagamento that = (FormaPagamento) o;

		return id != null ? id.equals(that.id) : that.id == null;

	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
}
