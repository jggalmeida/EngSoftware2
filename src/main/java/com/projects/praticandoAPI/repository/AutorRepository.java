package com.projects.praticandoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.projects.praticandoAPI.modelo.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	List<Autor> findByNome(String nomeAutor);
	Autor findByNomeAutor(String nomeAutor);

}