package com.myapp.biblioapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myapp.biblioapp.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

}
