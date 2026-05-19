package com.project.krl_ticketing_system.Service;

import com.project.krl_ticketing_system.Entity.Show;

public interface ShowService {

    public Show addShow(Show show);

    public Show getShow(Long showId);

    public String deleteShow(Long showId);
}
