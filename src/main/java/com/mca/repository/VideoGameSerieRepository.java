package com.mca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mca.infrastructure.model.VideoGameSerie;

import java.util.List;

public interface VideoGameSerieRepository extends JpaRepository<VideoGameSerie, Long> {
    List<VideoGameSerie> findBySerie(String serie);
}