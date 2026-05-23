package com.project.krl_ticketing_system.Controller;

import com.project.krl_ticketing_system.Entity.Seat;
import com.project.krl_ticketing_system.Entity.Theater;
import com.project.krl_ticketing_system.Service.TheaterService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
@AllArgsConstructor
public class TheaterController {

    private final TheaterService theaterService;

    @PostMapping("/addTheater/{locationId}")
    public ResponseEntity<?> add(@RequestBody Theater theater,@PathVariable Long locationId)
    {
        theaterService.addTheater(theater,locationId);
        return ResponseEntity.ok("Theater Sucessfully Added");
    }

    @GetMapping("/getTheaterById/{theaterId}")
    public ResponseEntity<?> getById(@PathVariable Long theaterId) {

        List<Theater> theater = theaterService.getTheaterByLocationId(theaterId);

        return ResponseEntity.ok(theater);
    }

    // Delete Theater
    @DeleteMapping("/deleteTheater/{theaterId}")
    public ResponseEntity<?> delete(@PathVariable Long locationId, @PathVariable Long theaterId) {

        String message = theaterService.deleteTheaterByLocationId(locationId,theaterId);

        return ResponseEntity.ok(message);
    }

    @GetMapping("/getSeats/{theaterId}")
    public List<Seat> getSeatsByTheater(@PathVariable Long theaterId)
    {
        return theaterService.getSeatsByTheater(theaterId);
    }
}
