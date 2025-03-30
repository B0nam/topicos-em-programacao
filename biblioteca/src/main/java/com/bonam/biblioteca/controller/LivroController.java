package com.bonam.biblioteca.controller;

import com.bonam.biblioteca.domain.dto.LivroDto;
import com.bonam.biblioteca.domain.model.Livro;
import com.bonam.biblioteca.domain.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroDto>> getLivros() {
        List<LivroDto> livros = livroService.getLivros();
        if (livros.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> getLivroById(@PathVariable Long id) {
        Optional<LivroDto> livro = livroService.getLivroById(id);
        return livro.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Livro> addLivro(@RequestBody LivroDto livro) {
        return new ResponseEntity<>(livroService.saveLivro(livro), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> updateLivro(@PathVariable Long id, @RequestBody LivroDto livro) {
        if (livroService.getLivroById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Livro livroAtualizado = livroService.saveLivro(livro);
        return new ResponseEntity<>(livroAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
        Optional<LivroDto> livro = livroService.getLivroById(id);
        if (livro.isPresent()) {
            livroService.removeLivro(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
