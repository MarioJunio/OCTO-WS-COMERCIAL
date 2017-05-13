package br.com.appvendas.mobile.holder;

import java.util.List;

public class ProdutoSincHolder {

	private Long dataSincronizacao;
	private List<ProdutoMobile> produtos;

	public Long getDataSincronizacao() {
		return dataSincronizacao;
	}

	public void setDataSincronizacao(Long dataSincronizacao) {
		this.dataSincronizacao = dataSincronizacao;
	}

	public List<ProdutoMobile> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoMobile> produtos) {
		this.produtos = produtos;
	}

}
