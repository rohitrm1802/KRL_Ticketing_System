package com.project.krl_ticketing_system.ServiceImpl;

import com.project.krl_ticketing_system.Entity.Location;
import com.project.krl_ticketing_system.Entity.Seat;
import com.project.krl_ticketing_system.Entity.Theater;
import com.project.krl_ticketing_system.Enum.SeatType;
import com.project.krl_ticketing_system.Repository.LocationRepository;
import com.project.krl_ticketing_system.Repository.SeatRepository;
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

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public Theater addTheater(Theater theater, Long locationId)
    {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(()-> new RuntimeException("Location Not Found"));

        theater.setLocation(location);

        Theater savedTheater = theaterRepository.save(theater);

        generateSeats(savedTheater);

        return savedTheater ;
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

    @Override
    public List<Seat> getSeatsByTheater(Long theaterId)
    {
        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(()-> new RuntimeException("Theater Not Found"));

        return theater.getSeats();
    }

    @Override
    public void generateSeats(Theater theater)
    {
        for(char i = 'A'; i <= 'C'; i++)
        {
            for(int j = 1; j <= 2; j++) {

                Seat seat = new Seat();

                if(i == 'A')
                    seat.setSeatType(SeatType.PLATINUM);
                else if(i == 'B')
                    seat.setSeatType(SeatType.GOLD);
                else
                    seat.setSeatType(SeatType.SILVER);

                seat.setRowNum(i);
                seat.setSeatNum(j);

                seat.setTheater(theater);

                seatRepository.save(seat);
            }
        }
    }
}
