package com.projects.praticandoAPI.controller.form;

import com.projects.praticandoAPI.modelo.Livro;
import com.projects.praticandoAPI.repository.LivroRepository;


public class LivroForm {

	private String nomeLivro;

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public Livro converter(LivroRepository livroRepository) {
		return new Livro(nomeLivro);
	}

}
