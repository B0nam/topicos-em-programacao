package com.campteam.start.services;

import com.campteam.start.domain.Campeonato;
import com.campteam.start.domain.Time;
import com.campteam.start.repository.CampeonatosRepository;
import com.campteam.start.repository.TimesRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.Long;
import java.util.List;
import java.util.Optional;

@Service
public class CampeonatosService {
    @Autowired
    CampeonatosRepository campeonatosRepository;

    @Autowired
    TimesRepository timesRepository;

    public Optional<Campeonato> findById(Long uuid) {
        return campeonatosRepository.findById(uuid);
    }

    public List<Campeonato> findAll() {
        return campeonatosRepository.findAll();
    }

    public Long create(Campeonato campeonato) {
        Campeonato camp = campeonatosRepository.save(campeonato);
        return camp.id;
    }

    public void delete(Long uuid) {
        campeonatosRepository.deleteById(uuid);
    }

    public Campeonato update(Campeonato campeonato) {
         return campeonatosRepository.save(campeonato);
    }

    public void addTeam(Long campeonatoId, Long timeId) throws BadRequestException {
        Time time =  timesRepository.findById(timeId).orElseThrow(BadRequestException::new);
        Campeonato camp = findById(campeonatoId).orElseThrow(BadRequestException::new);
        camp.times.add(time);
        timesRepository.save(time);
    }
}
