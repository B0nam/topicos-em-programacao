package com.campteam.start.repository;

import com.campteam.start.domain.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TimesRepository extends JpaRepository<Time, Long> {
}
