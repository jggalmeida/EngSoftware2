package com.projects.praticandoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.praticandoAPI.modelo.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	Autor findByNomeAutor(String nomeAutor);

}