//ALTERADO

package com.projects.praticandoAPI.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Editora implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEditora;
    private String nomeEditora;
    private String paisEditora;


	@OneToMany(mappedBy = "editora")
    //@JoinColumn(name="ID_EDITORA")
    private List <Livro> livros = new ArrayList<>();

	
	public Long getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Long idEditora) {
        this.idEditora = idEditora;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    public String getPaisEditora() {
        return paisEditora;
    }

    public void setPaisEditora(String paisEditora) {
        this.paisEditora = paisEditora;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEditora == null) ? 0 : idEditora.hashCode());
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
		Autor other = (Autor) obj;
		if (idEditora == null) {
			if (other.idEditora != null)
				return false;
		} else if (!idEditora.equals(other.idEditora))
			return false;
		return true;
	}


}


