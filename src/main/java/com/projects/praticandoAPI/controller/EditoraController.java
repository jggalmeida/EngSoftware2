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

import com.projects.praticandoAPI.controller.dto.EditoraDto;
import com.projects.praticandoAPI.controller.form.EditoraForm;

import com.projects.praticandoAPI.modelo.Editora;
import com.projects.praticandoAPI.repository.EditoraRepository;

@RestController

@RequestMapping("/editoras")
public class EditoraController {

	@Autowired
	private EditoraRepository editoraRepository;


	@GetMapping
	public List<EditoraDto> lista(String nomeEditora) {
		if (nomeEditora == null) {
			List<Editora> editoras = editoraRepository.findAll();
			return EditoraDto.converter(editoras);
		} else {
			List<Editora> editoras = editoraRepository.findByNomeEditora(nomeEditora);
			return EditoraDto.converter(editoras);
		}
	}

	@PostMapping
	public ResponseEntity<EditoraDto> cadastrar(@RequestBody EditoraForm form, UriComponentsBuilder uriBuilder) {
		Editora editora = form.converter(editoraRepository);
		editoraRepository.save(editora);

		URI uri = uriBuilder.path("/editora/{id}").buildAndExpand(editora.getIdEditora()).toUri();
		return ResponseEntity.created(uri).body(new EditoraDto(editora));
	}

}
