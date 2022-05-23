//ALTERADO

package com.projects.praticandoAPI.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

import java.io.Serializable;
import java.util.List;

@Entity
public class Autor implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAutor;
	private String nomeAutor;
    private String nacionalidadeAutor;


	@ManyToMany
    @JoinTable(
        name="LivrosAutores",
        uniqueConstraints = @UniqueConstraint(columnNames = {"idAutor", "idLivro"}),
        joinColumns = @JoinColumn(name = "idAutor"),
        inverseJoinColumns = @JoinColumn(name = "idLivro")
    )
    private List<Livro> livros;

	public Object idLivro;

	public Object idEditora;


	public Autor(String nomeAutor, String nacionalidadeAutor) {
		this.nomeAutor = nomeAutor;
		this.nacionalidadeAutor = nacionalidadeAutor;
	}
	
	public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getNacionalidadeAutor() {
        return nacionalidadeAutor;
    }

    public void setNacionalidadeAutor(String nacionalidadeAutor) {
        this.nacionalidadeAutor = nacionalidadeAutor;
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
		result = prime * result + ((idAutor == null) ? 0 : idAutor.hashCode());
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
		if (idAutor == null) {
			if (other.idAutor != null)
				return false;
		} else if (!idAutor.equals(other.idAutor))
			return false;
		return true;
	}


}


