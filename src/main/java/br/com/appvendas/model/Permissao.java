package br.com.appvendas.model;

public enum Permissao {
	
	ROLE_USER("USER"), ROLE_ADMIN("ADMIN");
	
	private String descricao;

	private Permissao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
}
