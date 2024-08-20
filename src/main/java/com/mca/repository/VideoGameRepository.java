package com.mca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mca.infrastructure.model.VideoGame;

import java.util.Optional;

public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {
    Optional<VideoGame> findById(Integer id);
}
