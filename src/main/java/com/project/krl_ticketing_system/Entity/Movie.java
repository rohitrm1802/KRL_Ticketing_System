package com.project.krl_ticketing_system.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String movie_name;

    private String description;

    private String language;

    private String runtime;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

}
