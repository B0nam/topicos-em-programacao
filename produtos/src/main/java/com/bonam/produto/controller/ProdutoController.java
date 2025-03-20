package com.bonam.produto.controller;

import com.bonam.produto.model.Produto;
import com.bonam.produto.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RestController("/produto")
public class ProdutoController {

    private ProdutoService produtoService;

    @GetMapping
    private ResponseEntity<List<Produto>> getAllProducts() {
        List<Produto> produtos = produtoService.getAll();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Produto> saveProduct(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.save(produto), HttpStatus.CREATED);
    }

    @DeleteMapping("{:id}")
    private ResponseEntity<Produto> deleteProduct(@PathVariable Long id) {
        try {
            produtoService.delete(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{:id}")
    private ResponseEntity<Produto> updateProduct(@PathVariable Long id, @RequestBody Produto produto) {
        Optional<Produto> produtoExistente = produtoService.getById(id);
        if (produtoExistente.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Produto produtoAtualizado = produtoExistente.get();
        produtoAtualizado.setNome(produto.getNome());
        produtoAtualizado.setPreco(produto.getPreco());
        produtoAtualizado.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque());

        return new ResponseEntity<>(produtoService.save(produtoAtualizado), HttpStatus.OK);
    }
}
