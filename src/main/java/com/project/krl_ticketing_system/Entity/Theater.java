package com.project.krl_ticketing_system.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String theater_name;
    public String address;

    @OneToMany(mappedBy = "theater")
    private List<Show> shows;

    @OneToMany(mappedBy = "theater")
    private List<Movie> movies;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
