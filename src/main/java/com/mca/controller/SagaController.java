package com.mca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.mca.infrastructure.model.VideoGame;
import com.mca.infrastructure.model.VideoGameSerie;
import com.mca.infrastructure.service.PromotionService;
import com.mca.infrastructure.service.StockService;
import com.mca.infrastructure.model.Stock;
import com.mca.infrastructure.model.Promotion;
import com.mca.repository.VideoGameSerieRepository;
import com.mca.repository.StockRepository;
import com.mca.repository.VideoGameRepository;

@RestController
@RequestMapping("/api/videogames")
public class SagaController {

    @Autowired
    private VideoGameSerieRepository repository;

    @Autowired
    private VideoGameRepository repositoryGame;

    @Autowired
    private StockService stockService;

    @Autowired
    private PromotionService promotionService;


    // Endpoint para obtener una serie de videojuegos por nombre de serie
    @GetMapping("/serie/{serie}")
    public List<VideoGameSerie> getBySerie(@PathVariable String serie) {
        return repository.findBySerie(serie);
    }

    // Endpoint para obtener un videojuego por su ID
    @GetMapping("/game/{id}")
    public ResponseEntity<VideoGame> getById(@PathVariable Integer id) {
        Optional<VideoGame> videoGame = repositoryGame.findById(id);
        return videoGame.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/game/{videoGameId}/stock")
    public List<Object[]> getStockByVideoGameId(@PathVariable Integer videoGameId) {
        return stockService.getVideoGameIdAndStock(videoGameId);
    }

    @GetMapping("/game/{videoGameId}/promotion")
    public List<Object[]> getPromotionByVideoGameId(@PathVariable Integer videoGameId) {
        return promotionService.getVideoGameIdAndPromotion(videoGameId);
    }
}
