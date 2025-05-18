package com.myapp.biblioapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myapp.biblioapp.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{

}
