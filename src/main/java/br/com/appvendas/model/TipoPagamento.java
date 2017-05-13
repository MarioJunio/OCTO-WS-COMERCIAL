package br.com.appvendas.model;

import java.io.Serializable;

/**
 * Created by MarioJ on 28/08/16.
 */
public enum TipoPagamento implements Serializable {

    DINHEIRO("Dinheiro"), APRAZO("A Prazo"), CHEQUE("Cheque"), BOLETO("Boleto"), CARTAO("Cartão");

    private String descricao;

    TipoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return name();
    }

    @Override
    public String toString() {
        return name();
    }
}
