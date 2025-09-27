package HotelManagementSystemLLD.observer;

import HotelManagementSystemLLD.entites.Booking;

public class Email implements Observer{

    @Override
    public void update(Booking booking) {
        System.out.printf("Email sent successfully to %s\n", booking.getGuest().getEmail());
    }
    
}
