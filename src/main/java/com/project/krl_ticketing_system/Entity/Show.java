package com.project.krl_ticketing_system.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "shows")
@Getter
@Setter
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String show_time;

    private String show_date;

    private int screen_num;

    private double ticket_price;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonBackReference
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

//    @OneToMany(mappedBy = "show")
//    private List<Seat> seats;

    @OneToMany(mappedBy = "show")
    private List<ShowSeat> ShowSeats;
}