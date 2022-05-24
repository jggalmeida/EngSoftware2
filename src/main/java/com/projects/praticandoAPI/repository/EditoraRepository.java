package com.projects.praticandoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.projects.praticandoAPI.modelo.Editora;

public interface EditoraRepository extends JpaRepository<Editora, Long> {
	List<Editora> findByNomeEditora(String nomeEditora);
	Editora findByNome(String nomeEditora);
}