package com.project.krl_ticketing_system.Controller;

import com.project.krl_ticketing_system.Entity.Movie;
import com.project.krl_ticketing_system.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/addMovie")
    public Movie addMovie(Movie movie)
    {
        return movieService.addMovie(movie);
    }

    @GetMapping("/getMovieId/{movieId}")
    public Movie getMovieById(Long movieId)
    {
        return movieService.getMovie(movieId);
    }

    @GetMapping("/getAllMovies")
    public List<Movie> getAllMovies()
    {
        return movieService.getAllMovies();
    }

    @DeleteMapping("/deleteMovie/{movieId}")
    public String deleteMovie(Long movieId)
    {
        return movieService.deleteMovie(movieId);
    }
}
