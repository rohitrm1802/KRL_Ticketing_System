package com.project.krl_ticketing_system.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Character seatNo;

    private Integer rowNo;

    @Enumerated(EnumType.STRING)
    private String seatType;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;
}
