package com.project.krl_ticketing_system.ServiceImpl;

import com.project.krl_ticketing_system.Entity.Movie;
import com.project.krl_ticketing_system.Entity.Show;
import com.project.krl_ticketing_system.Entity.Theater;
import com.project.krl_ticketing_system.Repository.MovieRepository;
import com.project.krl_ticketing_system.Repository.ShowRepository;
import com.project.krl_ticketing_system.Repository.TheaterRepository;
import com.project.krl_ticketing_system.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService
{
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Show addShow(Show show,Long theaterId,Long movieId)
    {
        Theater theater = theaterRepository.findById(theaterId)
                        .orElseThrow(()-> new RuntimeException("Theater Id Not Found"));

        show.setTheater(theater);

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(()-> new RuntimeException("Movie Id Not Found"));

        show.setMovie(movie);

        return showRepository.save(show);
    }

    @Override
    public List<Show> getShowByMovieId(Long movieId)
    {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(()-> new RuntimeException("Show Id Not Found"));

        List<Show> shows = movie.getShows();

        return shows;
    }

    @Override
    public List<Show> getShowByTheaterId(Long theaterId)
    {
        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(()-> new RuntimeException("Theater Id Not Found"));

        List<Show> shows = theater.getShows();

        return shows;
    }

    @Override
    public String deleteShow(Long showId,Long movieId,Long theaterId)
    {
        Movie movie = movieRepository.findById(movieId)
                        .orElseThrow(()-> new RuntimeException("Movie Id Not Found"));

        movie.setShows(null);

        Theater theater = theaterRepository.findById(theaterId)
                        .orElseThrow(()-> new RuntimeException("Theater Id Not Found"));

        theater.setShows(null);

        showRepository.deleteById(showId);

        return "Show Successfully Deleted";
    }
}
