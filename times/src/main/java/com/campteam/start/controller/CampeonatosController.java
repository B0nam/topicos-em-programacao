package com.campteam.start.controller;

import com.campteam.start.domain.Campeonato;
import com.campteam.start.domain.Time;
import com.campteam.start.services.CampeonatosService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.lang.Long;

@RestController
public class CampeonatosController {
    @Autowired
    CampeonatosService service;

    @GetMapping(value = "/campeonatos")
    public List<Campeonato> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/campeonatos/{uuid}")
    public Optional<Campeonato> findById(@PathVariable Long uuid) {
        return service.findById(uuid);
    }

    @PostMapping(value = "/campeonatos")
    public Long create(@RequestBody Campeonato campeonato) {
        return service.create(campeonato);
    }

    @DeleteMapping("/campeonatos/{uuid}")
    public void delete(@PathVariable Long uuid) {
        service.delete(uuid);
    }

    @PutMapping("/{uuid}")
    public Campeonato update(@RequestBody Campeonato campeonato) {
        return service.update(campeonato);
    }

    @PostMapping("/campeonatos/{campeonatoId}/times/{timeId}")
    public void addTeam(@PathVariable Long campeonatoId, @PathVariable Long timeId) throws BadRequestException {
        service.addTeam(campeonatoId, timeId);
    }
}
