package com.projects.praticandoAPI.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.projects.praticandoAPI.modelo.Aluno;

public class AlunoDto {

    private Long id;
	private String nome;
	private String curso;
    private String semestre;

    public AlunoDto(Aluno aluno) {
		super();
		this.id = aluno.getId();
		this.nome = aluno.getNome();
		this.curso = aluno.getCurso();
		this.semestre = aluno.getSemestre();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCurso() {
		return curso;
	}

	public String getSemestre() {
		return semestre;
	}
	
	public static List<AlunoDto> converter(List<Aluno> alunos) {
		return alunos.stream().map(AlunoDto::new).collect(Collectors.toList());
	}

}

