package com.projects.praticandoAPI.controller.form;



import com.projects.praticandoAPI.modelo.Editora;
import com.projects.praticandoAPI.repository.EditoraRepository;

public class EditoraForm {

	private String nomeEditora;
    private String paisEditora;


	public String getNomeEditora() {
		return nomeEditora;
	}

	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}

	public String getPaisEditora() {
		return paisEditora;
	}

	public void setPaisEditora(String paisEditora) {
		this.paisEditora = paisEditora;
	}

	public Editora converter(EditoraRepository editoraRepository) {
		return new Editora(nomeEditora, paisEditora);
	}

}
