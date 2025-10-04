package ConcertTicketBookingSystemLLD;

import java.time.LocalDate;
import java.util.List;

import ConcertTicketBookingSystemLLD.enums.SeatType;
import ConcertTicketBookingSystemLLD.model.Booking;
import ConcertTicketBookingSystemLLD.model.Concert;
import ConcertTicketBookingSystemLLD.model.Seat;
import ConcertTicketBookingSystemLLD.model.User;

public class ConcertTicketBookingSystemLLDMain {
    public static void main(String[] args) {
        ConcertTicketBookngSystem system = ConcertTicketBookngSystem.getInstance();
        User alice = new User("alice", "a@gmail.com");
        
        List<Seat> seats = List.of(new Seat(121, SeatType.STANDARD), new Seat(121, SeatType.STANDARD));
        Concert c1 = new Concert("AA", "Bailur", LocalDate.now().plusDays(2), seats);

        system.addConcert(c1);
        for(Concert c : system.serach("AA", "Bailur", LocalDate.now().plusDays(2))){
            System.out.println(c.getArtist());
        }

        system.addBooking(new Booking(alice, c1, List.of(seats.get(0))));
    }
}
