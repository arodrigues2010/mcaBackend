package com.mca.infrastructure.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class VideoGame {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @OneToMany(mappedBy = "videoGame", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Promotion> promotions;

    public VideoGame() {
    }

    public VideoGame(String title, Set<Promotion> promotions) {
        this.title = title;
        this.promotions = promotions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }
}
