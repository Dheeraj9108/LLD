package MovieBookingSystemLLD;

import java.util.List;
import java.util.Optional;

import MovieBookingSystemLLD.entities.Booking;
import MovieBookingSystemLLD.entities.Payment;
import MovieBookingSystemLLD.entities.Seat;
import MovieBookingSystemLLD.entities.Show;
import MovieBookingSystemLLD.entities.User;
import MovieBookingSystemLLD.enums.PaymentStatus;
import MovieBookingSystemLLD.strategry.PaymentStratergy;

public class BookingManager {

    private SeatLockManager seatLockManager;

    public BookingManager(SeatLockManager seatLockManager){
        this.seatLockManager = seatLockManager;
    }

    public Optional<Booking> createBooking(User user, Show show, List<Seat> seats, PaymentStratergy paymentStratergy) {
        seatLockManager.lockSeats(show, user, seats);

        double amount = show.getPricingStrtergy().calculate(seats);

        Payment payment = paymentStratergy.pay(amount);

        if(payment.getStatus() == PaymentStatus.DONE){
            Booking booking = new Booking(show, user, seats, payment);
            booking.confirmBooking();
            return Optional.of(booking);
        } else {
            System.out.println("Payment failed");
        }

        seatLockManager.unlockSeat(show,user,seats);
        return Optional.empty();
    }
}
