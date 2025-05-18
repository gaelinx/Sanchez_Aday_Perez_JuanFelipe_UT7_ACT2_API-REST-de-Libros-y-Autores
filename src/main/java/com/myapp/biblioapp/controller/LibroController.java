package com.myapp.biblioapp.controller;

import com.myapp.biblioapp.model.Libro;
import com.myapp.biblioapp.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/libro")
public class LibroController {
    private LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> getAllLibros(){
        return libroService.getAllLibros();
    }
    @PostMapping
    public Libro createLibro(@RequestBody Libro libro){
        return libroService.save(libro);
    }

    @PutMapping("/{id}")
    public Libro updateLibro(@PathVariable long id, @RequestBody Libro libro){
        return libroService.update(id, libro);
    }

    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable long id){
        return libroService.getLibroById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable long id){
        libroService.delete(id);
    }

    //filtros

}
