//ALTERADO

package com.projects.praticandoAPI.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.io.Serializable;

@Entity
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;
    private String nomeLivro;

    @ManyToOne
    private Editora editora;

    @ManyToOne
    private Autor autor;

    public Livro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public Livro() {
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idLivro == null) ? 0 : idLivro.hashCode());
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
        Livro other = (Livro) obj;
        if (idLivro == null) {
            if (other.idLivro != null)
                return false;
        } else if (!idLivro.equals(other.idLivro))
            return false;
        return true;
    }

}
