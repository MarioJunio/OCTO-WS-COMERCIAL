package br.com.appvendas.model;

import java.io.Serializable;

public enum Finalidade implements Serializable {

    VENDA("Venda"), MateriaPrima("Matéria Prima"), Consumo("Consumo");

    private String descricao;

    Finalidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Finalidade parse(String s) {

        if (s.equalsIgnoreCase("venda"))
            return VENDA;
        else if (s.equalsIgnoreCase("matéria prima"))
            return MateriaPrima;
        else if (s.equalsIgnoreCase("consumo"))
            return Consumo;

        return null;
    }
}
