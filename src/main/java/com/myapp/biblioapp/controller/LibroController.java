package com.myapp.biblioapp.controller;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.biblioapp.model.Libro;
import com.myapp.biblioapp.service.LibroService;

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
    @GetMapping("/buscar")
    public ResponseEntity<List<Libro>> buscarLibros(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) Integer anio, // Nuevo parámetro para año exacto
            @RequestParam(required = false) Integer anioMin,
            @RequestParam(required = false) Integer anioMax,
            @RequestParam(defaultValue = "id") List<String> sortBy,
            @RequestParam(defaultValue = "asc") String order) {

        // Si se especifica 'anio', ignora anioMin/anioMax
        if (anio != null) {
            anioMin = anio;
            anioMax = anio;
        }
        // Validación del parámetro order
        if (!order.equalsIgnoreCase("asc") && !order.equalsIgnoreCase("desc")) {
            throw new IllegalArgumentException("El parámetro 'order' debe ser 'asc' o 'desc'");
        }

        // Creación del objeto Sort
        Sort.Direction direction = order.equalsIgnoreCase("desc")
                ? Sort.Direction.DESC
                : Sort.Direction.ASC;

        Sort sort = Sort.by(direction, sortBy.toArray(new String[0]));

        List<Libro> resultados = libroService.buscarLibro(titulo, anioMin, anioMax, sort);
        return ResponseEntity.ok(resultados);
    }
}
