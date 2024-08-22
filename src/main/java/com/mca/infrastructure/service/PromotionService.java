package com.mca.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mca.repository.PromotionRepository;

import java.util.List;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    public List<Object[]> getVideoGameIdAndPromotion(Integer videoGameId) {
        return promotionRepository.findVideoGameIdAndPromotionByVideoGameId(videoGameId);
    }
}