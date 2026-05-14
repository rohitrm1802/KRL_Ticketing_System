package com.project.krl_ticketing_system.ServiceImpl;

import com.project.krl_ticketing_system.Entity.Movie;
import com.project.krl_ticketing_system.Repository.MovieRepository;
import com.project.krl_ticketing_system.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService
{
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie addMovie(Movie movie)
    {
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovie(Long movieId)
    {
        return movieRepository.findById(movieId)
                .orElseThrow(()-> new RuntimeException("Movie Id Not Found"));
    }

    @Override
    public List<Movie> getAllMovies()
    {
        return movieRepository.findAll();
    }

    @Override
    public String deleteMovie(Long movieId)
    {
        movieRepository.deleteById(movieId);
        return "Movie Successfully Deleted";
    }
}
