package com.project.krl_ticketing_system.Service;

import com.project.krl_ticketing_system.Entity.Show;

import java.util.List;

public interface ShowService {

    public Show addShow(Show show,Long theaterId,Long movieId);

    public List<Show> getShowByMovieId(Long movieId);

    public List<Show> getShowByTheaterId(Long theaterId);

    public String deleteShow(Long showId,Long movieId,Long theaterId);
}
