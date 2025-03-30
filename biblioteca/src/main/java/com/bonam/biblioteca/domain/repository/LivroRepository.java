package com.bonam.biblioteca.domain.repository;

import com.bonam.biblioteca.domain.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
