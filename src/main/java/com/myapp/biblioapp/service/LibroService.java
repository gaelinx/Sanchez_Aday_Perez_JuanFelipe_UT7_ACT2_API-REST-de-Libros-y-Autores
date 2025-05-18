package com.myapp.biblioapp.service;

import com.myapp.biblioapp.model.Libro;
import com.myapp.biblioapp.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> getAllLibros(){return libroRepository.findAll();}
    public  Libro save(Libro libro){return libroRepository.save(libro);}
    public void delete(long id){libroRepository.deleteById(id);}
    public Libro getLibroById(long id){return libroRepository.findById(id).orElse(null);}
    public Libro update(long id, Libro libro){
        libro.setId(id);
        return libroRepository.save(libro);
    }

    //filtros

    //buscar por titulo
    //buscar por año
    //sortBy (campo para ordenar)
    //filtrar por orden ascendente o descendente
}
