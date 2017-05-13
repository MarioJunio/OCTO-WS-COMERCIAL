package br.com.appvendas.mobile.holder;

import java.math.BigDecimal;

import br.com.appvendas.model.Categoria;
import br.com.appvendas.model.Marca;
import br.com.appvendas.model.Prateleira;
import br.com.appvendas.model.Produto;

public class ProdutoMobile {

	private Long id;
	private String nome;
	private Marca marca;
	private Categoria categoria;
	private Prateleira prateleira;
	private String ncm;
	private Long dataCadastro;
	private String descricao;
	private String unidade;
	private float quantidade;
	private float estoque;
	private BigDecimal valor;
	private String ean;
	private String finalidade;
	private String complemento;
	private boolean ignorarQuantidade;
	private Long dataAlteracao;

	public static ProdutoMobile buildWithWrap(Produto p) {
		
		ProdutoMobile produtoMobile = new ProdutoMobile();
		produtoMobile.setId(p.getId());
		produtoMobile.setNome(p.getNome());
		produtoMobile.setMarca(p.getMarca());
		produtoMobile.setCategoria(p.getCategoria());
		produtoMobile.setPrateleira(p.getPrateleira());
		produtoMobile.setNcm(p.getNcm());
		produtoMobile.setDataCadastro(p.getDataCadastro() != null ? p.getDataCadastro().getTimeInMillis() : null);
		produtoMobile.setDescricao(p.getDescricao());
		produtoMobile.setUnidade(p.getUnidade().getDescricao());
		produtoMobile.setQuantidade(p.getQuantidade());
		produtoMobile.setEstoque(p.getEstoque() != null ? p.getEstoque().floatValue() : 0f);
		produtoMobile.setValor(p.getValor() != null ? p.getValor() : BigDecimal.ZERO);
		produtoMobile.setEan(p.getEan());
		produtoMobile.setFinalidade(p.getFinalidade() != null ? p.getFinalidade().getDescricao() : null);
		produtoMobile.setComplemento(p.getComplemento());
		produtoMobile.setIgnorarQuantidade(p.isIgnorarQuantidade());
		produtoMobile.setDataAlteracao(p.getDataUltimaAlteracao() != null ? p.getDataUltimaAlteracao().getTimeInMillis() : null);
		
		return produtoMobile;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Prateleira getPrateleira() {
		return prateleira;
	}

	public void setPrateleira(Prateleira prateleira) {
		this.prateleira = prateleira;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public Long getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Long dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public float getEstoque() {
		return estoque;
	}

	public void setEstoque(float estoque) {
		this.estoque = estoque;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public boolean isIgnorarQuantidade() {
		return ignorarQuantidade;
	}

	public void setIgnorarQuantidade(boolean ignorarQuantidade) {
		this.ignorarQuantidade = ignorarQuantidade;
	}

	public Long getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Long dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoMobile other = (ProdutoMobile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
