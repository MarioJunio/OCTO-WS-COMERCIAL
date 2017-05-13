package br.com.appvendas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.appvendas.util.format.Dates;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String referencia;
	private Marca marca;
	private Categoria categoria;
	private String ncm;
	private Calendar dataCadastro;
	private String descricao;
	private Unidade unidade;
	private Prateleira prateleira;
	private float quantidade;
	private BigDecimal estoque;
	private BigDecimal custo;
	private BigDecimal valor;
	private String ean;
	private Finalidade finalidade;
	private byte[] foto;
	private Fornecedor fornecedor;
	private String complemento;
	private Markup markup;
	private boolean ignorarQuantidade;
	private Calendar dataUltimaAlteracao;

	// codigo temporario utilizada na tela de cadastro do produto
	private int tmpCodigo;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length = 80)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(length = 20, unique = true)
	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	@ManyToOne
	@JoinColumn(name = "marca_id")
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Column(name = "NCM")
	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro")
	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Column(length = 5000)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String apresentacao) {
		this.descricao = apresentacao;
	}

	@Enumerated(EnumType.STRING)
	@Column
	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	@ManyToOne
	@JoinColumn(name = "prateleira_id")
	public Prateleira getPrateleira() {
		return prateleira;
	}

	public void setPrateleira(Prateleira prateleira) {
		this.prateleira = prateleira;
	}

	@Column(precision = 10, scale = 3)
	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	@Column(precision = 10, scale = 3)
	public BigDecimal getEstoque() {
		return estoque;
	}

	public void setEstoque(BigDecimal estoque) {
		this.estoque = estoque;
	}

	@Column(precision = 10, scale = 3)
	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	@Column(precision = 10, scale = 3)
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Column(name = "EAN", unique = true)
	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	@Enumerated(EnumType.STRING)
	@Column
	public Finalidade getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(Finalidade finalidade) {
		this.finalidade = finalidade;
	}

	@Column(columnDefinition = "blob")
	@Lob
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@OneToOne
	@JoinColumn(name = "markup_id")
	public Markup getMarkup() {
		return markup;
	}

	public void setMarkup(Markup markup) {
		this.markup = markup;
	}

	@Column(length = 5000)
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Column(name = "ignorar_quantidade")
	public boolean isIgnorarQuantidade() {
		return ignorarQuantidade;
	}

	public void setIgnorarQuantidade(boolean ignorarQuantidade) {
		this.ignorarQuantidade = ignorarQuantidade;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	public Calendar getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(Calendar dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	@Transient
	public int getTmpCodigo() {
		return tmpCodigo;
	}

	public void setTmpCodigo(int tmpCodigo) {
		this.tmpCodigo = tmpCodigo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Produto produto = (Produto) o;

		return id != null ? id.equals(produto.id) : produto.id == null;

	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", dataUltimaAlteracao=" + ((dataUltimaAlteracao != null) ? Dates.toStringParam(dataUltimaAlteracao.getTime()) : "Nao tem") + "]";
	}

}
