package ConcertTicketBookingSystemLLD.model;

import java.util.UUID;

import ConcertTicketBookingSystemLLD.enums.SeatStatus;
import ConcertTicketBookingSystemLLD.enums.SeatType;

public class Seat {
    private String id;
    private double price;
    private SeatType type;
    private SeatStatus status;

    public Seat(double price, SeatType type) {
        this.id = UUID.randomUUID().toString();
        this.price = price;
        this.type = type;
        this.status = SeatStatus.AVAILABLE;
    }

    public void book(){
        this.status = SeatStatus.BOOKED;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public SeatType getType() {
        return type;
    }

    public SeatStatus getStatus() {
        return status;
    }

}
