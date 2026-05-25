package com.project.krl_ticketing_system.Controller;

import com.project.krl_ticketing_system.Entity.Location;
import com.project.krl_ticketing_system.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/addLocation/{location}")
    public String addLocation(@PathVariable String location)
    {
        return locationService.addLocation(location);
    }

    @GetMapping("/getLocation")
    public List<Location> getLocation()
    {
        return locationService.getAllLocation();
    }

    @DeleteMapping("/deleteLocation")
    public String deleteLocation(@PathVariable Long locationId)
    {
        return locationService.deleteLocation(locationId);
    }
}
