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

import com.projects.praticandoAPI.controller.dto.AutorDto;
import com.projects.praticandoAPI.controller.form.TopicoForm;

import com.projects.praticandoAPI.modelo.Autor;
import com.projects.praticandoAPI.repository.AutorRepository;
import com.projects.praticandoAPI.repository.EditoraRepository;
import com.projects.praticandoAPI.repository.LivroRepository;

@RestController

@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private EditoraRepository editoraRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping
	public List<AutorDto> lista(String nomeAutor) {
		if (nomeAutor == null) {
			List<Autor> autores = autorRepository.findAll();
			return AutorDto.converter(autores);
		} else {
			List<Autor> autores = autorRepository.findByNome(nomeAutor);
			return AutorDto.converter(autores);
		}
	}
	
	@PostMapping
	public ResponseEntity<AutorDto> cadastrar(@RequestBody TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new AutorDto(topico));
	}

}
