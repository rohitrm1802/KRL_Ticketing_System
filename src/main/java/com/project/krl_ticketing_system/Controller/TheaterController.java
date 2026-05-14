package com.project.krl_ticketing_system.Controller;

import com.project.krl_ticketing_system.Entity.Theater;
import com.project.krl_ticketing_system.Service.TheaterService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theater")
@AllArgsConstructor
public class TheaterController {
    private  final TheaterService theaterService;

    @PostMapping("/addTheater")
    public ResponseEntity<?> add(@RequestBody Theater theater)
    {
        theaterService.addTheater(theater);
        return ResponseEntity.ok("Theater Sucessfully Added");
    }
    @GetMapping("/getTheaterById/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {

        Theater theater = theaterService.getTheaterById(id);
        return ResponseEntity.ok(theater);
    }

    // Get All Theaters
    @GetMapping("/getAllTheater")
    public ResponseEntity<?> getAll() {

        List<Theater> theaters = theaterService.getAllTheater();
        return ResponseEntity.ok(theaters);
    }

    // Delete Theater
    @DeleteMapping("/deleteTheater/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        String message = theaterService.deleteTheater(id);

        return ResponseEntity.ok(message);
    }
}
