package com.mca.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mca.repository.VideoGameRepository;
import com.mca.infrastructure.model.VideoGame;
import java.util.List;
import java.util.Optional;

@Service
public class VideoGameService {

   
    @Autowired
    private VideoGameRepository repository;

    // Crear o actualizar un VideoGame
    public VideoGame createOrUpdateVideoGame(VideoGame videoGame) {
        return repository.save(videoGame);
    }

    // Obtener todos los VideoGames
    public List<VideoGame> getAllVideoGames() {
        return repository.findAll();
    }

    // Obtener un VideoGame por su ID
    public Optional<VideoGame> findById(Long id) {
        return repository.findById(id);
    }

    // Eliminar un VideoGame por su ID
    public void deleteVideoGame(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
