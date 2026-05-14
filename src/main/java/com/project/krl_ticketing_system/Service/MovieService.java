package com.project.krl_ticketing_system.Service;

import com.project.krl_ticketing_system.Entity.Movie;

import java.util.List;

public interface MovieService {

    public Movie addMovie(Movie movie);

    public Movie getMovie(Long movieId);

    public List<Movie> getAllMovies();

    public String deleteMovie(Long movieId);
}
