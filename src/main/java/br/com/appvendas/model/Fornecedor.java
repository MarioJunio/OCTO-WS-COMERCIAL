package br.com.appvendas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "fornecedor")
@PrimaryKeyJoinColumn
public class Fornecedor extends Pessoa {

    private String cnpj;
    private String inscest;
    private String razaoSocial;
    private List<Produto> produtos;

    @Column(length = 20)
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Column(length = 20)
    public String getInscest() {
        return inscest;
    }

    public void setInscest(String inscest) {
        this.inscest = inscest;
    }

    @Column(name = "razao_social", length = 60)
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "fornecedor")
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> derivados) {
        this.produtos = derivados;
    }
}
