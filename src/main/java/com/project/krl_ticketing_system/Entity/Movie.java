package com.project.krl_ticketing_system.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @JsonIgnore
    private Theater theater;

    @OneToMany(mappedBy = "movie")
    private List<Show> shows;

}
