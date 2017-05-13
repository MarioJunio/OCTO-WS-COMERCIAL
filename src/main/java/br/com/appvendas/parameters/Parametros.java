package br.com.appvendas.parameters;

public enum Parametros {

	Param_Sinc_Produto(1l), Param_Quantidade_Mobile(2l), Param_Sinc_Cliente(3l), Param_Sinc_Forma_Pagamento(4l);

	private Long codigo;

	Parametros(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCodigo() {
		return codigo;
	}

}
