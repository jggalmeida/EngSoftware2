package com.projects.praticandoAPI.controller.dto;
import com.projects.praticandoAPI.modelo.Autor;

import java.util.List;
import java.util.stream.Collectors;



public class AutorDto {

	private Long idAutor;
	private String nomeAutor;
    private String nacionalidadeAutor;
	
	public AutorDto(Autor autor) {
		this.idAutor = autor.getIdAutor();
		this.nomeAutor = autor.getNomeAutor();
		this.nacionalidadeAutor = autor.getNacionalidadeAutor();
	}

	public AutorDto() {
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getNacionalidadeAutor() {
		return nacionalidadeAutor;
	}


	public static List<AutorDto> converter(List<Autor> autores) {
		return autores.stream().map(AutorDto::new).collect(Collectors.toList());
	}

}
