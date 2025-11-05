package MovieBookingSystemLLD;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import MovieBookingSystemLLD.entities.Booking;
import MovieBookingSystemLLD.entities.Movie;
import MovieBookingSystemLLD.entities.Screen;
import MovieBookingSystemLLD.entities.Seat;
import MovieBookingSystemLLD.entities.Show;
import MovieBookingSystemLLD.entities.User;
import MovieBookingSystemLLD.enums.SeatStatus;
import MovieBookingSystemLLD.enums.SeatType;
import MovieBookingSystemLLD.strategry.CreditCard;
import MovieBookingSystemLLD.strategry.Weekday;

public class MovieBookingSystemLLDMain {
    public static void main(String[] args) {
        MovieBookingService service = MovieBookingService.getInstance();

        // 2. Add movies
        Movie matrix = new Movie("M1", "The Matrix", 120);
        Movie avengers = new Movie("M2", "Avengers: Endgame", 170);
        service.addMovie(matrix);
        service.addMovie(avengers);

        // Add Seats for a Screen
        Screen screen1 = new Screen("S1");

        for (int i = 1; i <= 10; i++) {
            screen1.addSeat(new Seat("A" + i,i <= 5 ? SeatType.REGULAR : SeatType.PREMIUM, 1, i));
            screen1.addSeat(new Seat("B" + i,i <= 5 ? SeatType.REGULAR : SeatType.PREMIUM, 2, i));
        }

        // Add Cinemas

        // Add Shows
        Show matrixShow = service.addShow("show1", matrix, screen1, LocalDateTime.now().plusHours(2), new Weekday());
        Show avengersShow = service.addShow("show2", avengers, screen1, LocalDateTime.now().plusHours(5), new Weekday());

        // --- User and Observer Setup ---
        User alice = service.createUser("Alice", "alice@example.com");


        // 1. Search for shows
        
        Show selectedShow = matrixShow; // Alice selects the first show

        // 2. View available seats
        List<Seat> availableSeats = selectedShow.getScreen().getSeats().stream()
                .filter(seat -> seat.getStatus() == SeatStatus.AVAILABLE)
                .toList();
        System.out.printf("Available seats for '%s' at %s: %s%n",
                selectedShow.getMovie().getTitle(),
                selectedShow.getDate(),
                availableSeats.stream().map(Seat::getId).collect(Collectors.toList()));

        // 3. Select seats
        List<Seat> desiredSeats = List.of(availableSeats.get(2), availableSeats.get(3));
        System.out.println("Alice selects seats: " + desiredSeats.stream().map(Seat::getId).toList());

        // 4. Book Tickets
        Optional<Booking> bookingOpt = service.createBooking(
                alice.getId(),
                selectedShow.getId(),
                desiredSeats,
                new CreditCard()
        );

        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            System.out.println("\n--- Booking Successful! ---");
            System.out.println("Booking ID: " + booking.getId());
            System.out.println("User: " + booking.getUser().getName());
            System.out.println("Movie: " + booking.getShow().getMovie().getTitle());
            System.out.println("Seats: " + booking.getSeats().stream().map(Seat::getId).toList());
            System.out.println("Total Amount: $" + booking.getPayment().getAmount());
            System.out.println("Payment Status: " + booking.getPayment().getStatus());
        } else {
            System.out.println("Booking failed.");
        }

        // 5. Verify seat status after booking
        System.out.println("\nSeat status after Alice's booking:");
        desiredSeats.forEach(seat -> System.out.printf("Seat %s status: %s%n", seat.getId(), seat.getStatus()));

        // 6. Shut down the system to release resources like the scheduler.
        service.shutdown();
    }
}
