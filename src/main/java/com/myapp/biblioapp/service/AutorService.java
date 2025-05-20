package com.myapp.biblioapp.service;

import com.myapp.biblioapp.model.Autor;
import com.myapp.biblioapp.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    public Autor getAutorById(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    public void deleteAutor(Long id) {
        autorRepository.deleteById(id);
    }

}
