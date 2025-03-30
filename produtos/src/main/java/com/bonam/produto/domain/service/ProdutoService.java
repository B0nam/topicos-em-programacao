package com.bonam.produto.domain.service;

import com.bonam.produto.domain.model.Produto;
import com.bonam.produto.domain.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoService {

    public ProdutoRepository produtoRepository;

    public Optional<Produto> getById(Long id) {
        return Optional.of(produtoRepository.getReferenceById(id));
    }

    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }

    public void delete(Long id){
        produtoRepository.deleteById(id);
    }
}
