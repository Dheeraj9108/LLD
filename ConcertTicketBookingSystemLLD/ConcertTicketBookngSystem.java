package ConcertTicketBookingSystemLLD;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ConcertTicketBookingSystemLLD.model.Booking;
import ConcertTicketBookingSystemLLD.model.Concert;

public class ConcertTicketBookngSystem {
    private static ConcertTicketBookngSystem INSTANCE;
    private Map<String,Concert> concerts;
    private Map<String,Booking> bookings;

    private ConcertTicketBookngSystem(){
        concerts = new HashMap<>();
        bookings = new HashMap<>();
    }

    public static ConcertTicketBookngSystem getInstance(){
        if(INSTANCE == null){
            synchronized(ConcertTicketBookngSystem.class){
                if(INSTANCE == null){
                    INSTANCE = new ConcertTicketBookngSystem();
                }
            }
        }
        return INSTANCE;
    }

    public void addBooking(Booking booking){
        bookings.put(booking.getId(), booking);
        System.out.println("Booking Success");
    }

    public void addConcert(Concert concert){
        concerts.put(concert.getId(), concert);
    }

    public List<Concert> serach(String artist, String venue, LocalDate date){
        return concerts.values().stream()
            .filter(concert -> concert.getArtist().equals(artist) && concert.getVenue().equals(venue) && concert.getDate().equals(date))
            .collect(Collectors.toList());
    }
}
