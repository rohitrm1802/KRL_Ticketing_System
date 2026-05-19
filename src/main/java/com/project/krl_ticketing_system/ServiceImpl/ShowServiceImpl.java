package com.project.krl_ticketing_system.ServiceImpl;

import com.project.krl_ticketing_system.Entity.Show;
import com.project.krl_ticketing_system.Repository.ShowRepository;
import com.project.krl_ticketing_system.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowServiceImpl implements ShowService
{
    @Autowired
    private ShowRepository showRepository;

    @Override
    public Show addShow(Show show)
    {
        return showRepository.save(show);
    }

    @Override
    public Show getShow(Long showId)
    {
        return showRepository.findById(showId)
                .orElseThrow(()-> new RuntimeException("Show Id Not Found"));
    }

    @Override
    public String deleteShow(Long showId)
    {
        showRepository.deleteById(showId);
        return "Show Successfully Deleted";
    }
}
