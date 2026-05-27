package com.project.krl_ticketing_system.ServiceImpl;

import com.project.krl_ticketing_system.DTO.SeatBook;
import com.project.krl_ticketing_system.Entity.*;
import com.project.krl_ticketing_system.Enum.SeatType;
import com.project.krl_ticketing_system.Repository.*;
import com.project.krl_ticketing_system.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Override
    public Show addShow(Show show,Long theaterId,Long movieId)
    {
        Theater theater = theaterRepository.findById(theaterId)
                        .orElseThrow(()-> new RuntimeException("Theater Id Not Found"));

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(()-> new RuntimeException("Movie Id Not Found"));

        show.setTheater(theater);

        show.setMovie(movie);

        List<Seat> seats = theater.getSeats();

        Show savedShow = showRepository.save(show);

        for(Seat seat : seats)
        {
            ShowSeat showSeat = new ShowSeat();

            showSeat.setSeat(seat);

            showSeat.setShow(show);

            if(seat.getSeatType() == SeatType.PLATINUM)
            {
                showSeat.setPrice(show.getPlatinum_price());
            }
            else if(seat.getSeatType() == SeatType.GOLD)
            {
                showSeat.setPrice(show.getGold_price());
            }
            else
            {
                showSeat.setPrice(show.getSilver_price());
            }

            showSeat.setBooked(false);

            showSeatRepository.save(showSeat);
        }

        return showRepository.save(show);
    }

    @Override
    public List<Show> getShowByMovieId(Long movieId)
    {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(()-> new RuntimeException("Show Id Not Found"));

        return movie.getShows();
    }

    @Override
    public List<Show> getShowByTheaterId(Long theaterId)
    {
        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(()-> new RuntimeException("Theater Id Not Found"));

        List<Movie> movies = theater.getMovies();

        List<Show> allShows = new ArrayList<>();

        for(Movie movie : movies)
        {
            List<Show> shows = movie.getShows();

            allShows.addAll(shows);
        }

        return allShows;
    }

    @Override
    public String deleteShow(Long showId,Long movieId,Long theaterId)
    {
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show Id Not Found"));

        if(!show.getMovie().getId().equals(movieId))
        {
            throw new RuntimeException("Movie Id Not Found");
        }

        else if(!show.getTheater().getId().equals(theaterId))
        {
            throw new RuntimeException("Theater Id Not Found");
        }

        showSeatRepository.deleteAll(show.getShowSeats());

        showRepository.deleteById(showId);

        return "Show Successfully Deleted";
    }

    public String bookSeat(SeatBook seatBook,Long showId)
    {

        Show show = showRepository.findById(showId)
                .orElseThrow(()-> new RuntimeException("Show Not Found"));

        List<ShowSeat> showSeats = show.getShowSeats();

        for(ShowSeat s1 : showSeats)
        {
            if(s1.getRowNum() == seatBook.getRowNum()
                                        && s1.getSeatNum() == seatBook.getSeatNum())
            {
                seatBook.setFound(true);

                if(s1.isBooked())
                    throw new RuntimeException("Seat Is Already Booked");
                else
                {
                    s1.setBooked(true);
                    showSeatRepository.save(s1);
                }
            }
        }
        if(!seatBook.isFound())
            throw new RuntimeException("Invalid Seat Number");

        return "Seat Booked Successfully";

    }
}
