package com.mca.infrastructure.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime validFrom;

    @Column(precision = 5, scale = 2)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "videogame_id", nullable = false)
    private VideoGame videoGame;

    // Getters y Setters
    // Constructors
    public Promotion() {
    }

    public Promotion(LocalDateTime validFrom, BigDecimal price, VideoGame videoGame) {
        this.validFrom = validFrom;
        this.price = price;
        this.videoGame = videoGame;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public VideoGame getVideoGame() {
        return videoGame;
    }

    public void setVideoGame(VideoGame videoGame) {
        this.videoGame = videoGame;
    }
}
