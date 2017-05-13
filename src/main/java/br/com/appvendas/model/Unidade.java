package br.com.appvendas.model;

public enum Unidade {

    Und("UND"), GR("GR"), KG("KG"), LT("LT");

    String descricao;

    Unidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Object parse(String s) {

        if (s.equalsIgnoreCase("UND"))
            return Und;
        else if (s.equalsIgnoreCase("GR"))
            return GR;
        else if (s.equalsIgnoreCase("KG"))
            return KG;
        else if (s.equalsIgnoreCase("LT"))
            return LT;

        return null;
    }
}
