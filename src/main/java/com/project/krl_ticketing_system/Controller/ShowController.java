package com.project.krl_ticketing_system.Controller;

import com.project.krl_ticketing_system.Entity.Show;
import com.project.krl_ticketing_system.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/add")
    public Show addShow(@RequestBody Show show)
    {
        return showService.addShow(show);
    }

    @GetMapping("/getShow/{showId}")
    public Show getShow(@PathVariable Long showId)
    {
        return showService.getShow(showId);
    }

    @DeleteMapping("/delete/{showId}")
    public String deleteShow(@PathVariable Long showId)
    {
        return showService.deleteShow(showId);
    }
}
