package com.myapp.biblioapp.controller;

import com.myapp.biblioapp.model.Autor;
import com.myapp.biblioapp.service.AutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping public List<Autor> getAllAutores() {
        return autorService.getAllAutores();
    }

    @GetMapping("/{id}") public Autor getAutorById(@PathVariable Long id) {
        return autorService.getAutorById(id);
    }

    @PostMapping public Autor createAutor(@RequestBody Autor autor) {
        return autorService.save(autor);
    }

    @DeleteMapping("/{id}") public void deleteAutor(@PathVariable Long id) {
        autorService.deleteAutor(id);
    }

    @PutMapping("/{id}") public Autor updateAutor(@PathVariable Long id, @RequestBody Autor autor) {
        return autorService.update(id, autor);
    }

}
