package ConcertTicketBookingSystemLLD.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Concert {
    private String id;
    private String artist;
    private String venue;
    private LocalDate date;
    private List<Seat> seats;

    public Concert(String artist, String venue, LocalDate date, List<Seat> seats){
        this.id = UUID.randomUUID().toString();
        this.artist = artist;
        this.venue = venue;
        this.date = date;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public String getVenue() {
        return venue;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    
}
