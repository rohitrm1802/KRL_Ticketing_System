package com.project.krl_ticketing_system.Entity;

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

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;
}
