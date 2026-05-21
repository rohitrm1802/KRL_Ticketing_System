package com.project.krl_ticketing_system.Service;

import com.project.krl_ticketing_system.Entity.Location;

import java.util.List;

public interface LocationService {

    public String addLocation(String location);

    public List<Location> getAllLocation();

    public String deleteLocation(Long locationId);
}
