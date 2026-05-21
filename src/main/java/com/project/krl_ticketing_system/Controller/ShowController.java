package com.project.krl_ticketing_system.Controller;

import com.project.krl_ticketing_system.Entity.Show;
import com.project.krl_ticketing_system.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/add/{theaterId}/{movieId}")
    public Show addShow(@RequestBody Show show,@PathVariable Long theaterId, @PathVariable Long movieId)
    {
        return showService.addShow(show,theaterId,movieId);
    }

    @GetMapping("/getShowByMovie/{movieId}")
    public List<Show> getShow(@PathVariable Long movieId)
    {
        return showService.getShowByMovieId(movieId);
    }

    @GetMapping("/getShowByTheater/{theaterId}")
    public List<Show> getShowByTheater(@PathVariable Long theaterId)
    {
        return showService.getShowByTheaterId(theaterId);
    }

    @DeleteMapping("/delete/{showId}/{movieId}/{theaterId}")
    public String deleteShow(@PathVariable Long showId
                            ,@PathVariable Long movieId
                            ,@PathVariable Long theaterId)
    {
        return showService.deleteShow(showId,movieId,theaterId);
    }
}
