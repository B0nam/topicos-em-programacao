package com.campteam.start.controller;

import com.campteam.start.domain.Time;
import com.campteam.start.services.TimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.lang.Long;

@RestController
public class TimesController {
    @Autowired
    TimesService service;

    @GetMapping(value = "/times")
    public List<Time> findAll() {
        return service.findAll();
    }

    @GetMapping("/times/{uuid}")
    public Optional<Time> findById(@PathVariable Long uuid) {
        return service.findById(uuid);
    }

    @PostMapping(value = "/times")
    public Long create(@RequestBody Time time) {
        return service.create(time);
    }

    @DeleteMapping(value = "/times/{uuid}")
    public void delete(@PathVariable Long uuid) {
        service.delete(uuid);
    }

    @PutMapping(value = "/times/{uuid}")
    public Time update(@RequestBody Time time) {
        return service.update(time);
    }
}
