package com.bonam.biblioteca.domain.service;

import com.bonam.biblioteca.domain.dto.LivroDto;
import com.bonam.biblioteca.domain.model.Livro;
import com.bonam.biblioteca.domain.repository.LivroRepository;
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

    public List<LivroDto> getLivros() {
        return livroRepository.findAll().stream().map(LivroDto::toDto).toList();
    }

    public Optional<LivroDto> getLivroById(Long id) {
        return livroRepository.findById(id).map(LivroDto::toDto);
    }

    public Livro saveLivro(LivroDto livro) {
        return livroRepository.save(Livro.builder()
                        .autor(livro.getAutor())
                        .descricao(livro.getDescricao())
                        .titulo(livro.getTitulo())
                        .statusEmprestimo(livro.getStatusEmprestimo())
                        .build());
    }

    public void removeLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
