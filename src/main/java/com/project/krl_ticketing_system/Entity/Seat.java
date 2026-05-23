package com.project.krl_ticketing_system.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.krl_ticketing_system.Enum.SeatType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Character rowNum;

    private Integer seatNum;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

//    @ManyToOne
//    @JoinColumn(name = "show_id")
//    private Show show;

    @OneToMany(mappedBy = "seat")
    private List<ShowSeat> ShowSeats;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    @JsonBackReference
    private Theater theater;

}
