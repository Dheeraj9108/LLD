package MovieBookingSystemLLD;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import MovieBookingSystemLLD.entities.Booking;
import MovieBookingSystemLLD.entities.Movie;
import MovieBookingSystemLLD.entities.Screen;
import MovieBookingSystemLLD.entities.Seat;
import MovieBookingSystemLLD.entities.Show;
import MovieBookingSystemLLD.entities.User;
import MovieBookingSystemLLD.strategry.PaymentStratergy;
import MovieBookingSystemLLD.strategry.PricingStrategry;

public class MovieBookingService {
    private static MovieBookingService INSTANCE;
    private Map<String, User> users;
    private Map<String, Show> shows;
    private Map<String, Movie> movies;
    private SeatLockManager seatLockManager;
    private BookingManager bookingManager;

    private MovieBookingService() {
        users = new HashMap<>();
        shows = new HashMap<>();
        movies = new HashMap<>();
        seatLockManager = new SeatLockManager();
        bookingManager = new BookingManager(seatLockManager);
    }

    public static MovieBookingService getInstance() {
        if (INSTANCE == null) {
            synchronized (MovieBookingService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieBookingService();
                }
            }
        }
        return INSTANCE;
    }

    public User createUser(String name, String email) {
        User user = new User(name, email);
        users.put(user.getId(), user);
        return user;
    }

    public Movie addMovie(Movie movie) {
        movies.put(movie.getId(), movie);
        return movie;
    }

    public Show addShow(String id, Movie movie, Screen screen, LocalDateTime date, PricingStrategry pricingStratergy) {
        Show show = new Show(id, movie, screen, date, pricingStratergy);
        shows.put(show.getId(), show);
        return show;
    }

    public Optional<Booking> createBooking(String userId, String showId, List<Seat> seats, PaymentStratergy paymentStratergy){
        return bookingManager.createBooking(users.get(userId), shows.get(showId), seats, paymentStratergy);
    } 

    public void shutdown(){
        seatLockManager.shutdown();
    }
}
