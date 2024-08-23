package com.mca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.mca.infrastructure.model.VideoGame;
import com.mca.infrastructure.model.VideoGameSerie;
import com.mca.infrastructure.service.PromotionService;
import com.mca.infrastructure.service.StockService;
import com.mca.infrastructure.service.VideoGameService;
import com.mca.repository.VideoGameSerieRepository;
import com.mca.repository.VideoGameRepository;

@RestController
@RequestMapping("/game")
public class SagaController {

    @Autowired
    private VideoGameSerieRepository repository;

    @Autowired
    private VideoGameRepository repositoryGame;

    @Autowired
    private StockService stockService;

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private VideoGameService videoGameService;

    // Endpoint para obtener una serie de videojuegos por nombre de serie
    @GetMapping("/serie/{serie}")
    public List<VideoGameSerie> getBySerie(@PathVariable String serie) {
        return repository.findBySerie(serie);
    }

    // Endpoint para obtener un videojuego por su ID
    @GetMapping("/{id}/saga")
    public ResponseEntity<VideoGame> getById(@PathVariable Long id) {
        Optional<VideoGame> videoGame = videoGameService.findById(id);
        return videoGame.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{videoGameId}/stock")
    public ResponseEntity<List<Object[]>> getStockByVideoGameId(@PathVariable Long videoGameId) {
        List<Object[]> stockList = stockService.getVideoGameIdAndStock(videoGameId);

        if (stockList == null || stockList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(stockList);
    }

    @GetMapping("/{videoGameId}/promotion")
    public ResponseEntity<List<Object[]>> getPromotionByVideoGameId(@PathVariable Long videoGameId) {
        List<Object[]> promotionList = promotionService.getVideoGameIdAndPromotion(videoGameId);

        if (promotionList == null || promotionList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(promotionList);
    }

    @PostMapping("/create")
    public ResponseEntity<VideoGame> createVideoGame(@RequestBody VideoGame videoGame) {
        try {
            VideoGame savedVideoGame = repositoryGame.save(videoGame);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedVideoGame);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Obtener todos los VideoGames
    @GetMapping("/all")
    public ResponseEntity<List<VideoGame>> getAllVideoGames() {
        try {
            List<VideoGame> videoGames = videoGameService.getAllVideoGames();
            return ResponseEntity.ok(videoGames);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Eliminar un VideoGame por su ID
    @DeleteMapping("{id}/promotion")
    public ResponseEntity<Void> deleteVideoGame(@PathVariable Long id) {
        try {
            if (videoGameService.findById(id).isPresent()) {
                promotionService.deletePromotionsByVideoGameId(id);
                return ResponseEntity.status(HttpStatus.OK).build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
