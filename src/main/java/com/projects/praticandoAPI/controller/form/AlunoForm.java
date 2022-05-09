package com.projects.praticandoAPI.controller.form;

//import com.projects.praticandoAPI.modelo.Curso;
//import com.projects.praticandoAPI.modelo.Topico;
import com.projects.praticandoAPI.modelo.Aluno;
//import com.projects.praticandoAPI.repository.CursoRepository;
import com.projects.praticandoAPI.repository.AlunoRepository;

public class AlunoForm {

    private String nome;
	private String curso;
	private String semestre;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public String getSemestre() {
		return semestre;
	}
	
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	public Aluno converter(AlunoRepository alunoRepository) {
		
		return new Aluno(nome, curso, semestre);
	}
    
}
