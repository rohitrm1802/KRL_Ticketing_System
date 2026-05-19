package com.project.krl_ticketing_system.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shows")
@Getter
@Setter
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String show_time;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Theater theater;
}
