package com.bonam.biblioteca.domain.dto;

import com.bonam.biblioteca.domain.model.Livro;
import com.bonam.biblioteca.domain.types.StatusEmprestimo;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LivroDto {
    private String titulo;
    private String autor;
    private String descricao;
    private StatusEmprestimo statusEmprestimo;

    public static LivroDto toDto(Livro livro) {
        return LivroDto.builder()
                .autor(livro.getAutor())
                .titulo(livro.getTitulo())
                .descricao(livro.getDescricao())
                .statusEmprestimo(livro.getStatusEmprestimo())
                .build();
    };
}
