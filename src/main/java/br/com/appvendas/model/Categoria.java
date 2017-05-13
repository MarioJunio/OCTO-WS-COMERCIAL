package br.com.appvendas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable, Comparable<Categoria> {

	private static final long serialVersionUID = 5937938809413532411L;
	
	public static final String ID = "id";
    public static final String NOME = "nome";

    private Long id;
    private String nome;

    @Id
    @GeneratedValue
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categoria categoria = (Categoria) o;

        return !(id != null ? !id.equals(categoria.id) : categoria.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public int compareTo(Categoria o) {
        return getNome().compareTo(o.getNome());
    }
}

