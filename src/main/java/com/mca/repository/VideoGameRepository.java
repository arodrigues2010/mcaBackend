package com.mca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mca.infrastructure.model.VideoGame;

import java.util.List;

public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {
    List<VideoGame> findById(Integer id);
}
