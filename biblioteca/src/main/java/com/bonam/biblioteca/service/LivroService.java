package com.bonam.biblioteca.service;

import com.bonam.biblioteca.model.Livro;
import com.bonam.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> getLivros() {
        return livroRepository.findAll();
    }

    public Optional<Livro> getLivroById(Long id) {
        return livroRepository.findById(id);
    }

    public Livro saveLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public void removeLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
