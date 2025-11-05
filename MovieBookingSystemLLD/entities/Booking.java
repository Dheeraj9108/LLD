package MovieBookingSystemLLD.entities;

import java.util.List;
import java.util.UUID;

import MovieBookingSystemLLD.enums.SeatStatus;

public class Booking {
    private String id;
    private Show show;
    private User user;
    private List<Seat> seats;
    private Payment payment;
    public Booking(Show show, User user, List<Seat> seats, Payment payment) {
        this.id = UUID.randomUUID().toString();
        this.show = show;
        this.user = user;
        this.seats = seats;
        this.payment = payment;
    }

    public void confirmBooking(){
        for(Seat seat : seats){
            seat.setStatus(SeatStatus.BOOKED);
        }
    }
    public String getId() {
        return id;
    }
    public Show getShow() {
        return show;
    }
    public User getUser() {
        return user;
    }
    public List<Seat> getSeats() {
        return seats;
    }
    public Payment getPayment() {
        return payment;
    }

}
