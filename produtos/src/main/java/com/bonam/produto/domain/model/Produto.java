package com.bonam.produto.domain.model;

import com.bonam.produto.domain.types.StatusEmprestimo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String nome;
    @NonNull
    private Double preco;
    @NonNull
    private Integer quantidadeEmEstoque;
    @NonNull
    @Enumerated(EnumType.STRING)
    private StatusEmprestimo statusEmprestimo;
}
