package com.project.krl_ticketing_system.ServiceImpl;

import com.project.krl_ticketing_system.Entity.Theater;
import com.project.krl_ticketing_system.Repository.TheaterRepository;
import com.project.krl_ticketing_system.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {

    @Autowired
     private  TheaterRepository theaterRepository;

    @Override
    public Theater addTheater(Theater theater) {
        return theaterRepository.save(theater) ;
    }

    @Override
    public Theater getTheaterById(Long id) {
        return theaterRepository.findById(id).orElseThrow(()->new RuntimeException("Theater Id Not Found "));
    }

    @Override
    public List<Theater> getAllTheater() {
        return theaterRepository.findAll();
    }

    @Override
    public String deleteTheater(Long id) {
        theaterRepository.deleteById(id);
        return "Theater Deleted Succesfully";
    }
}
