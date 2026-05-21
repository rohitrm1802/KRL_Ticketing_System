package com.project.krl_ticketing_system.ServiceImpl;

import com.project.krl_ticketing_system.Entity.Location;
import com.project.krl_ticketing_system.Repository.LocationRepository;
import com.project.krl_ticketing_system.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LocationServiceImpl implements LocationService
{
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public String addLocation(String location)
    {
        Location location1 = new Location();
        location1.setLocation(location);

        locationRepository.save(location1);

        return "Location Added Successfully";
    }

    @Override
    public List<Location> getAllLocation()
    {
        return locationRepository.findAll();
    }

    @Override
    public String deleteLocation(Long locationId)
    {
        locationRepository.deleteById(locationId);
        return "Location Deleted Successfully";
    }
}
