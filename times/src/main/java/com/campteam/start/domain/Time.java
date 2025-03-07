package com.campteam.start.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Time")
public class Time {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public long id;

    public String nome;

    @ManyToMany
    public List<Campeonato> campeonatos;
}
