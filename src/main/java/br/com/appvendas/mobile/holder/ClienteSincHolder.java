package br.com.appvendas.mobile.holder;

import java.util.List;

import br.com.appvendas.model.Cliente;

public class ClienteSincHolder {

	private Long dataSincronizacao;
	private List<Cliente> clientes;

	public ClienteSincHolder(Long dataSincronizacao, List<Cliente> clientes) {
		super();
		this.dataSincronizacao = dataSincronizacao;
		this.clientes = clientes;
	}

	public Long getDataSincronizacao() {
		return dataSincronizacao;
	}

	public void setDataSincronizacao(Long dataSincronizacao) {
		this.dataSincronizacao = dataSincronizacao;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
