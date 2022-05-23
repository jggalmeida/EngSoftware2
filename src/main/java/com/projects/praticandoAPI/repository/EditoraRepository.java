package com.projects.praticandoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.praticandoAPI.modelo.Editora;

public interface EditoraRepository extends JpaRepository<Editora, Long> {
	Editora findByNomeEditora(String nomeEditora);
}
