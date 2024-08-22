package com.mca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mca.infrastructure.model.VideoGame;


public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {

}
