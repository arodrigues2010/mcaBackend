package com.mca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.mca.infrastructure.model.VideoGame;
import com.mca.infrastructure.model.VideoGameSerie;
import com.mca.repository.VideoGameSerieRepository;
import com.mca.repository.VideoGameRepository;
import com.mca.infrastructure.model.VideoGame;

import org.springframework.http.ResponseEntity;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/Videogames")
public class SagaController {

    @Autowired
    private VideoGameSerieRepository repository;

    @Autowired
    private VideoGameRepository  repositoryGame;

    @GetMapping("/serie/{serie}")
    public List<VideoGameSerie> getBySerie(@PathVariable String serie) {
        return repository.findBySerie(serie);
    }


    @GetMapping("/game/{id}")
    public List<VideoGame> getById(@PathVariable Integer id) {
        return repositoryGame.findById(id);
    }
}