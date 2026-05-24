package com.project.krl_ticketing_system.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "theater")
    private List<Show> shows;

    @JsonIgnore
    @OneToMany(mappedBy = "theater")
    private List<Movie> movies;

    @ManyToOne
    @JoinColumn(name = "location_id")
    @JsonIgnore
    private Location location;

    @OneToMany(mappedBy = "theater")
    private List<Seat> seats;
}
