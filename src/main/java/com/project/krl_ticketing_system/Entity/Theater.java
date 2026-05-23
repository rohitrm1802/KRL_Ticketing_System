package com.project.krl_ticketing_system.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "theaters")
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

    @OneToMany(mappedBy = "theater")
    @JsonManagedReference
    private List<Seat> seats;
}
