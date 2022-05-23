package com.projects.praticandoAPI.controller.form;

import com.projects.praticandoAPI.modelo.Autor;
import com.projects.praticandoAPI.repository.AutorRepository;

public class AutorForm {

	private String nomeAutor;
    private String nacionalidadeAutor;

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

	public Autor converter(AutorRepository autorRepository) {
		//Curso curso = cursoRepository.findByNome(nomeCurso);
		return new Autor(nomeAutor, nacionalidadeAutor);
	}

}
