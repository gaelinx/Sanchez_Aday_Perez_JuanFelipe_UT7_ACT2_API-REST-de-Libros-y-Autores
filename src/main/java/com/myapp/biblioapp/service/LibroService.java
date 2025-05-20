package com.myapp.biblioapp.service;

import java.time.Year;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myapp.biblioapp.model.Libro;
import com.myapp.biblioapp.repository.LibroRepository;

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

    public List<Libro> buscarLibro(String titulo, Integer anioMin, Integer anioMax, Sort sort) {
        // Validación de años
        if (anioMin != null && anioMax != null && anioMin > anioMax) {
            throw new IllegalArgumentException("El año mínimo no puede ser mayor al año máximo");
        }
        String filtroTitulo = (titulo == null || titulo.isBlank()) ? "%" : "%" + titulo.toLowerCase() + "%";
        int filtroAnioMin = (anioMin == null) ? 0 : anioMin;
        int filtroAnioMax = (anioMax == null) ? Year.now().getValue() : anioMax;
        return libroRepository.findByTituloLikeIgnoreCaseAndAnioPublicacionBetween(
                filtroTitulo, filtroAnioMin, filtroAnioMax, sort);
    }

    //buscar por titulo
    //buscar por año
    //sortBy (campo para ordenar)
    //filtrar por orden ascendente o descendente
}
