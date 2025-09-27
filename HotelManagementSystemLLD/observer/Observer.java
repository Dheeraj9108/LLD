package HotelManagementSystemLLD.observer;

import HotelManagementSystemLLD.entites.Booking;

public interface Observer {
    public void update(Booking booking);    
}
