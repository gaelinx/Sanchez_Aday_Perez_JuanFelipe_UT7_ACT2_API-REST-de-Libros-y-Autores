package com.myapp.biblioapp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.biblioapp.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{

    List<Libro> findByTituloLikeIgnoreCaseAndAnioPublicacionBetween(
            String titulo, int anioMin, int anioMax, Sort sort);
}

