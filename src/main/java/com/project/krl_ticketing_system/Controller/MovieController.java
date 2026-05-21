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

    @PostMapping("/addMovie/{theaterId}")
    public Movie addMovie(@RequestBody Movie movie,@PathVariable Long theaterId)
    {
        return movieService.addMovie(movie,theaterId);
    }

    @GetMapping("/getMovieId/{movieId}")
    public List<Movie> getMovieById(@PathVariable Long movieId)
    {
        return movieService.getMovieByTheater(movieId);
    }

    @DeleteMapping("/deleteMovie/{movieId}")
    public String deleteMovie(@PathVariable Long theaterId,@PathVariable Long movieId)
    {
        return movieService.deleteMovieByTheater(theaterId,movieId);
    }
}
