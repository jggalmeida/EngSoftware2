package com.projects.praticandoAPI.controller.dto;
import com.projects.praticandoAPI.modelo.Editora;

import java.util.List;
import java.util.stream.Collectors;



public class EditoraDto {

	private Long idEditora;
    private String nomeEditora;
    private String paisEditora;
	
	public EditoraDto(Editora editora) {
		this.idEditora = editora.getIdEditora();
		this.nomeEditora = editora.getNomeEditora();
		this.paisEditora = editora.getPaisEditora();
	}

	public EditoraDto(){
		
	}

	public Long getIdEditora() {
		return idEditora;
	}

	public String getNomeEditora() {
		return nomeEditora;
	}

	public String getPaisEditora() {
		return paisEditora;
	}

	public static List<EditoraDto> converter(List<Editora> editoras) {
		return editoras.stream().map(EditoraDto::new).collect(Collectors.toList());
	}

}
