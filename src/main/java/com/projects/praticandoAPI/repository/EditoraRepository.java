package com.projects.praticandoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.praticandoAPI.modelo.Editora;
import java.util.List;


public interface EditoraRepository extends JpaRepository<Editora, Long> {
	List<Editora> findByCursoNome(String nomeEditora);
}
