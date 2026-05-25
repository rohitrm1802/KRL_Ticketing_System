package com.project.krl_ticketing_system.Controller;

import com.project.krl_ticketing_system.Entity.Movie;
import com.project.krl_ticketing_system.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/addMovie/{theaterId}")
    public Movie addMovie(@RequestBody Movie movie,@PathVariable Long theaterId)
    {
        return movieService.addMovie(movie,theaterId);
    }

    @GetMapping("/getMovieId/{theaterId}")
    public List<Movie> getMovieByTheater(@PathVariable Long theaterId)
    {
        return movieService.getMovieByTheater(theaterId);
    }

    @DeleteMapping("/deleteMovie/{theaterId}/{movieId}")
    public String deleteMovie(@PathVariable Long theaterId,@PathVariable Long movieId)
    {
        return movieService.deleteMovieByTheater(theaterId,movieId);
    }
}
