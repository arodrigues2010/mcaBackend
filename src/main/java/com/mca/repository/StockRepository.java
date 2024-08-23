package com.mca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.mca.infrastructure.model.Stock;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
     List<Object[]> findVideoGameIdAndStockByVideoGameId(@Param("videoGameId") Long videoGameId);
}