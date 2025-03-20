package com.campteam.start.repository;

import com.campteam.start.domain.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CampeonatosRepository extends JpaRepository<Campeonato, Long> {
}
