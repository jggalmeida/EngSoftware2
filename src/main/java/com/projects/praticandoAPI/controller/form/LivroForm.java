package com.projects.praticandoAPI.controller.form;

import com.projects.praticandoAPI.modelo.Autor;
//import com.projects.praticandoAPI.modelo.Editora;
import com.projects.praticandoAPI.modelo.Livro;
import com.projects.praticandoAPI.repository.AutorRepository;
//import com.projects.praticandoAPI.repository.EditoraRepository;
import com.projects.praticandoAPI.repository.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class LivroForm {

	private String nomeLivro;
	private String nomeEditora;
	private String nomeAutor;

	@Autowired
	private AutorRepository autorRepository;

	//@Autowired
	//private EditoraRepository editoraRepository;

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
		//Editora editora = editoraRepository.findByNome(nomeEditora);
		Autor autor = autorRepository.findByNomeAutor(nomeAutor);
		return new Livro(nomeLivro, autor);
	}

}
