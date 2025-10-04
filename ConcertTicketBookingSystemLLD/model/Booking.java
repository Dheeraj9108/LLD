package ConcertTicketBookingSystemLLD.model;

import java.util.List;
import java.util.UUID;

import ConcertTicketBookingSystemLLD.enums.BookingStatus;

public class Booking {
    private String id;
    private User user;
    private Concert concert;
    private double price;
    private BookingStatus status;
    private List<Seat> seats;

    public Booking(User user, Concert concert, List<Seat> seats) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.concert = concert;
        this.seats = seats;
        this.price = calculatePrice(seats);
        this.status = BookingStatus.PENDING;
    }

    public double calculatePrice(List<Seat> seats) {
        return seats.stream().mapToDouble(Seat::getPrice).sum();
    }

    public void confirmBooking() {
        this.status = BookingStatus.BOOKED;
    }

    public void cancel(){
        this.status = BookingStatus.CANCELED;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Concert getConcert() {
        return concert;
    }

    public double getPrice() {
        return price;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public List<Seat> getSeats() {
        return seats;
    }

}
