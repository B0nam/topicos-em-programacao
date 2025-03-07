package com.campteam.start.services;

import com.campteam.start.domain.Time;
import com.campteam.start.repository.TimesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.lang.Long;

@Service
public class TimesService {
    @Autowired
    TimesRepository repository;

    public Optional<Time> findById(Long uuid) {
        return repository.findById(uuid);
    }

    public List<Time> findAll() {
        return repository.findAll();
    }

    public Long create(Time time) {
        Time novoTime = repository.save(time);
        return novoTime.id;
    }

    public void delete(Long uuid) {
        repository.deleteById(uuid);
    }

    public Time update(Time campeonato) {
        return repository.save(campeonato);
    }
}
