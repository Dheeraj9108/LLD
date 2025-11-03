package UberLLD.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import UberLLD.observer.TripObserver;

public abstract class User implements TripObserver{
    
    private String id;
    private String name;
    private String contact;
    private List<Trip> tripHistory;
    
    public User(String name, String contact) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.contact = contact;
        this.tripHistory = new ArrayList<>();
    }

    public void addTripHistory(Trip trip){
        tripHistory.add(trip);
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<Trip> getTripHistory() {
        return tripHistory;
    }

    public String getContact() {
        return contact;
    }
    
}
