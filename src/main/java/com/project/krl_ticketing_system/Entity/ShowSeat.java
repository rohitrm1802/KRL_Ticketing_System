package com.project.krl_ticketing_system.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "show_seats")
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;

    private boolean booked;

    private char rowNum;

    private int seatNum;

    @ManyToOne
    @JoinColumn(name = "show_id")
    @JsonIgnore
    private Show show;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    @JsonIgnore
    private Seat seat;
}
