package com.project.krl_ticketing_system.Service;

import com.project.krl_ticketing_system.Entity.Movie;

import java.util.List;

public interface MovieService {

    public Movie addMovie(Movie movie, Long theaterId);

    public List<Movie> getMovieByTheater(Long theaterId);

    public String deleteMovieByTheater(Long theaterId,Long movieId);
}
