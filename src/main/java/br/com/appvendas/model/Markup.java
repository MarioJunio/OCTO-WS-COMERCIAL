
package br.com.appvendas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Markup implements Serializable {

    private Long id;
    private float margemLucro;
    private float icms;
    private float pisCofins;
    private float comissao;
    private float desconto;
    private float despesasAdmin;
    private boolean manual;
    private Produto produto;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "margem_lucro", precision = 10, scale = 4)
    public float getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(float margemLucro) {
        this.margemLucro = margemLucro;
    }

    @Column(precision = 10, scale = 4)
    public float getIcms() {
        return icms;
    }

    public void setIcms(float icms) {
        this.icms = icms;
    }

    @Column(name = "pis_cofins", precision = 10, scale = 4)
    public float getPisCofins() {
        return pisCofins;
    }

    public void setPisCofins(float pisCofins) {
        this.pisCofins = pisCofins;
    }

    @Column(precision = 10, scale = 4)
    public float getComissao() {
        return comissao;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    @Column(precision = 10, scale = 4)
    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    @Column(name = "despesas_admin", precision = 10, scale = 4)
    public float getDespesasAdmin() {
        return despesasAdmin;
    }

    public void setDespesasAdmin(float despesasAdmin) {
        this.despesasAdmin = despesasAdmin;
    }

    @Column()
    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "markup")
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto derivado) {
        this.produto = derivado;
    }

    @Transient
    public BigDecimal calcular(BigDecimal custo) {

        float pv = 100;
        float ctv = getMargemLucro() + getIcms() + getPisCofins() + getComissao() + getDesconto() + getDespesasAdmin();

        System.out.println("MARGEM LUCRO=" + getMargemLucro());
        System.out.println("ICMS=" + getIcms());
        System.out.println("PIS COFINS=" + getPisCofins());
        System.out.println("COMISSAO=" + getComissao());
        System.out.println("DESCONTO=" + getDesconto());
        System.out.println("DESPESA ADMIN=" + getDespesasAdmin());

        System.out.println("CTV = " + ctv);

        float mkd = (pv - ctv) / 100;

        System.out.println("MKD = " + mkd);

        return custo.divide(BigDecimal.valueOf(mkd), 2, RoundingMode.HALF_EVEN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Markup markup = (Markup) o;

        return id != null ? id.equals(markup.id) : markup.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

