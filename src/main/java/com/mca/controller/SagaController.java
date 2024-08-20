package com.mca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.mca.infrastructure.model.VideoGame;
import com.mca.infrastructure.model.VideoGameSerie;
import com.mca.repository.VideogamesRepository;
import com.mca.infrastructure.model.VideoGame;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/Videogames")
public class SagaController {

    @Autowired
    private VideogamesRepository repository;

    @GetMapping("/serie/{serie}")
    public List<VideoGameSerie> getBySerie(@PathVariable String serie) {
        return repository.findBySerie(serie);
    }
}