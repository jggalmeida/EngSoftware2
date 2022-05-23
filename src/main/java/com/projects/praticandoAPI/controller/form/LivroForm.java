package com.projects.praticandoAPI.controller.form;

import java.util.List;

import com.projects.praticandoAPI.modelo.Autor;
import com.projects.praticandoAPI.modelo.Editora;
import com.projects.praticandoAPI.repository.AutorRepository;

public class LivroForm {

	private String nomeLivro;
	private String editora;
	private List<String> autores;


	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public List<String> getAutores() {
		List<Autor> autores = AutorRepository.findAll(autores);
		return autores;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}


	public Autor converter(AutorRepository autorRepository) {
		//Curso curso = cursoRepository.findByNome(nomeCurso);
		return new Autor(nomeAutor, nacionalidadeAutor);
	}

}
