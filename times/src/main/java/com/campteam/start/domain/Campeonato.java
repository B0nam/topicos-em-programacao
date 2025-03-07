package com.campteam.start.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Campeonato")
public class Campeonato {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Id
    public Long id;

    public Date dataInicial;

    public Date dataFinal;

    @ManyToMany
    @Getter
    public List<Time> times;
}
