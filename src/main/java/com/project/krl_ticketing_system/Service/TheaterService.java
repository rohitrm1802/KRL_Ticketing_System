package com.project.krl_ticketing_system.Service;

import com.project.krl_ticketing_system.Entity.Theater;

import java.util.List;

public interface TheaterService {

    public Theater addTheater(Theater theater);
    public Theater getTheaterById(Long id);
    List<Theater> getAllTheater();
    public String deleteTheater(Long id);
}
