package com.project.krl_ticketing_system.ServiceImpl;

import com.project.krl_ticketing_system.Entity.Location;
import com.project.krl_ticketing_system.Entity.Theater;
import com.project.krl_ticketing_system.Repository.LocationRepository;
import com.project.krl_ticketing_system.Repository.TheaterRepository;
import com.project.krl_ticketing_system.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {

    @Autowired
     private  TheaterRepository theaterRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Theater addTheater(Theater theater,Long locationId)
    {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(()-> new RuntimeException("Location Not Found"));

        theater.setLocation(location);

        return theaterRepository.save(theater) ;
    }

    @Override
    public List<Theater> getTheaterByLocationId(Long locationId)
    {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(()-> new RuntimeException("Location Not Found"));

        return location.getTheater();
    }

    @Override
    public String deleteTheaterByLocationId(Long locationId,Long theaterId)
    {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(()-> new RuntimeException("Location Not Found"));

        theaterRepository.findById(theaterId)
                        .orElseThrow(()-> new RuntimeException("Theater Not Found"));

        location.getTheater().remove(theaterId);

        return "Theater Successfully Deleted";


    }
}
