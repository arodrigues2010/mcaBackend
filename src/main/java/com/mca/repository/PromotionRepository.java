package com.mca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.mca.infrastructure.model.Promotion;

import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
     List<Object[]> findVideoGameIdAndPromotionByVideoGameId(@Param("videoGameId") Integer videoGameId);
}
