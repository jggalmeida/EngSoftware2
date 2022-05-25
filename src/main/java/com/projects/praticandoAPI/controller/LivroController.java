package com.projects.praticandoAPI.controller;

import java.net.URI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.projects.praticandoAPI.controller.dto.LivroDto;
import com.projects.praticandoAPI.controller.form.LivroForm;

import com.projects.praticandoAPI.modelo.Livro;
import com.projects.praticandoAPI.repository.LivroRepository;

@RestController

@RequestMapping("/livros")
public class LivroController {

	//@Autowired
	//private AutorRepository autorRepository;

	// @Autowired
	// private EditoraRepository editoraRepository;

	 @Autowired
	 private LivroRepository livroRepository;

	@GetMapping
	public List<LivroDto> lista(String nomeLivro) {
		if (nomeLivro == null) {
			List<Livro> livros = livroRepository.findAll();
			return LivroDto.converter(livros);
		} else {
			//List<Livro> livros = livroRepository.findByNome(nomeLivro);
			//return LivroDto.converter(livros);
			return null;
		}
	}

	@PostMapping
	public ResponseEntity<LivroDto> cadastrar(@RequestBody LivroForm form, UriComponentsBuilder uriBuilder) {
		Livro livro = form.converter(livroRepository);
		livroRepository.save(livro);

		URI uri = uriBuilder.path("/livro/{id}").buildAndExpand(livro.getIdLivro()).toUri();
		return ResponseEntity.created(uri).body(new LivroDto(livro));
	}

}
