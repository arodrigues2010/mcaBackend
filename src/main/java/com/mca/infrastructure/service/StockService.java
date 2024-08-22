package com.mca.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mca.repository.StockRepository;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Object[]> getVideoGameIdAndStock(Integer videoGameId) {
        return stockRepository.findVideoGameIdAndStockByVideoGameId(videoGameId);
    }
}

