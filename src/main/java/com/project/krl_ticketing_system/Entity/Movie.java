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

//    spring.application.name=krl_ticketing_system
//    spring.datasource.url=jdbc:mysql://localhost:3306/ticket_db
//    spring.datasource.username=root
//    spring.datasource.password=root
//    spring.jpa.show-sql=true
//    spring.jpa.hibernate.ddl-auto=create
//    spring.jpa.properties.hibernate.format_sql=true
//    server.port=8088

}
