package br.com.appvendas.mobile.holder;

import java.util.List;

import br.com.appvendas.model.FormaPagamento;

public class FormaPagamentoHolder {

	private Long dataSincronizacao;
	private List<FormaPagamento> formasPagamento;

	public FormaPagamentoHolder(Long dataSincronizacao, List<FormaPagamento> formasPagamento) {
		super();
		this.dataSincronizacao = dataSincronizacao;
		this.formasPagamento = formasPagamento;
	}

	public Long getDataSincronizacao() {
		return dataSincronizacao;
	}

	public void setDataSincronizacao(Long dataSincronizacao) {
		this.dataSincronizacao = dataSincronizacao;
	}

	public List<FormaPagamento> getFormasPagamento() {
		return formasPagamento;
	}

	public void setFormasPagamento(List<FormaPagamento> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

}
