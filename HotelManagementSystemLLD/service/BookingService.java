package HotelManagementSystemLLD.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import HotelManagementSystemLLD.entites.Booking;
import HotelManagementSystemLLD.entites.Guest;
import HotelManagementSystemLLD.entites.Room;
import HotelManagementSystemLLD.observer.Observer;

public class BookingService {
    
    private List<Booking> bookings;
    private List<Observer> observers;
    
    public BookingService() {
        bookings = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void notifyObservers(Booking booking){
        for(Observer observer : observers){
            observer.update(booking);
        }
    }
    
    public Booking createBooking(Room room, Guest guest, LocalDate startDate, LocalDate enDate){
        Booking booking  = new Booking(room, guest, startDate, enDate);
        bookings.add(booking);
        booking.getRoom().book();
        notifyObservers(booking);
        return booking;
    }
}
