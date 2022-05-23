package com.projects.praticandoAPI.controller.form;

import java.util.List;

import com.projects.praticandoAPI.modelo.Autor;
import com.projects.praticandoAPI.modelo.Editora;
import com.projects.praticandoAPI.repository.AutorRepository;
import com.projects.praticandoAPI.repository.EditoraRepository;
import com.projects.praticandoAPI.repository.LivroRepository;

public class LivroForm {

	private String nomeLivro;
	private String nomeEditora;
	private String nomeAutor;

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getNomeEditora() {
		return nomeEditora;
	}

	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public Livro converter(LivroRepository livroRepository) {
		// Editora editora = EditoraRepository.findByNomeEditora(nomeEditora);
		Autor autor = AutorRepository.findByNomeAutor(nomeAutor);
		return new Livro(nomeLivro, editora, autor);
	}

}
