package com.project.krl_ticketing_system.ServiceImpl;

import com.project.krl_ticketing_system.Entity.Movie;
import com.project.krl_ticketing_system.Entity.Theater;
import com.project.krl_ticketing_system.Repository.MovieRepository;
import com.project.krl_ticketing_system.Repository.TheaterRepository;
import com.project.krl_ticketing_system.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService
{
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Override
    public Movie addMovie(Movie movie,Long theaterId)
    {
        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(()-> new RuntimeException("Theater Id Not Found"));

        movie.setTheater(theater);

        movie.setShows(null);

        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getMovieByTheater(Long theaterId)
    {
        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(()-> new RuntimeException("Theater Not Found"));

        return theater.getMovies();
    }

    @Override
    public String deleteMovieByTheater(Long theaterId,Long movieId)
    {
        Theater theater = theaterRepository.findById(theaterId)
                        .orElseThrow(()-> new RuntimeException("Theater Not Found"));

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(()-> new RuntimeException("Movie Not Found"));

        theater.getMovies().remove(movie);

        theaterRepository.save(theater);

        return "Movie Successfully Deleted";
    }
}
