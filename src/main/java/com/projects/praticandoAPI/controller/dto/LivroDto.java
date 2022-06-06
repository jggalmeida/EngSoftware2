package com.projects.praticandoAPI.controller.dto;
import com.projects.praticandoAPI.modelo.Livro;

import java.util.List;
import java.util.stream.Collectors;



public class LivroDto {

	private Long idLivro;
    private String nomeLivro;
	
	public LivroDto(Livro livro) {
		this.idLivro = livro.getIdLivro();
		this.nomeLivro = livro.getNomeLivro();
	}

	public LivroDto(){
		
	}

	public Long getIdLivro() {
		return idLivro;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public static List<LivroDto> converter(List<Livro> livros) {
		return livros.stream().map(LivroDto::new).collect(Collectors.toList());
	}

}
