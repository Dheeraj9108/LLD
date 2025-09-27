package HotelManagementSystemLLD.observer;

import HotelManagementSystemLLD.entites.Booking;

public class Sms implements Observer{

    @Override
    public void update(Booking booking) {
        System.out.printf("SMS sent successfully to %s\n", booking.getGuest().getName());
    }
    
}
