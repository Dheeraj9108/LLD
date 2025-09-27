package HotelManagementSystemLLD.entites;

import java.time.LocalDate;
import java.util.UUID;

import HotelManagementSystemLLD.enums.BookingStatus;

public class Booking {

    private String bookingId;
    private Room room;
    private Guest guest;
    private LocalDate startDate;
    private LocalDate enDate;
    private BookingStatus status;
    
    public Booking(Room room, Guest guest, LocalDate startDate, LocalDate enDate) {
        this.bookingId = UUID.randomUUID().toString();
        this.room = room;
        this.guest = guest;
        this.startDate = startDate;
        this.enDate = enDate;
        this.status = BookingStatus.BOOKED;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEnDate() {
        return enDate;
    }

    public BookingStatus getStatus() {
        return status;
    }
}
