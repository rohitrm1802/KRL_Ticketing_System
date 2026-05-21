package com.project.krl_ticketing_system.Service;

import com.project.krl_ticketing_system.Entity.Theater;

import java.util.List;

public interface TheaterService {

    public Theater addTheater(Theater theater,Long locationId);

    public List<Theater> getTheaterByLocationId(Long id);

    public String deleteTheaterByLocationId(Long locationId,Long theaterId);
}
