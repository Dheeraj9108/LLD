package UberLLD.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import UberLLD.enums.TripStatus;
import UberLLD.observer.TripObserver;
import UberLLD.state.Requested;
import UberLLD.state.TripState;

public class Trip {
    private String id;
    private TripStatus status;
    private Location pick;
    private Location drop;
    private List<TripObserver> observers;
    private double fare;
    private Driver driver;
    private Rider rider;
    private TripState state;

    public Trip(TripBuilder builder) {
        this.id = UUID.randomUUID().toString();
        status = TripStatus.REQUESTED;
        this.pick = builder.pick;
        this.drop = builder.drop;
        this.rider = builder.rider;
        this.fare = builder.fare;
        this.state = new Requested();
        observers = new ArrayList<>();
    }

    public void addObserver(TripObserver observer) {
        observers.add(observer);
    }

    public void notifyAllObserver() {
        observers.forEach(observer -> observer.onUpdate(this));
    }

    public void assignDriver(Driver driver) {
        state.assign(this, driver);
        addObserver(driver);
        notifyAllObserver();
    }
    
    public void start(){
        state.start(this);
        notifyAllObserver();
    }
    
    public void end(){
        state.end(this);
        notifyAllObserver();
    }

    public void setState(TripState state){
        this.state = state;
    }

    public void setStatus(TripStatus status){
        this.status = status;
    }

    public void setDriver(Driver driver){
        this.driver = driver;
    }

    public static class TripBuilder {
        private Rider rider;
        private double fare;
        private Location pick;
        private Location drop;

        public TripBuilder setRider(Rider rider) {
            this.rider = rider;
            return this;
        }

        public TripBuilder setFare(double fare) {
            this.fare = fare;
            return this;
        }

        public TripBuilder setPick(Location pick) {
            this.pick = pick;
            return this;
        }

        public TripBuilder setDrop(Location drop) {
            this.drop = drop;
            return this;
        }

        public Trip build(){
            return new Trip(this);
        }
    }

    public String getId() {
        return id;
    }

    public TripStatus getStatus() {
        return status;
    }

    public Location getPick() {
        return pick;
    }

    public Location getDrop() {
        return drop;
    }

    public List<TripObserver> getObservers() {
        return observers;
    }

    public double getFare() {
        return fare;
    }

    public Driver getDriver() {
        return driver;
    }

    public Rider getRider() {
        return rider;
    }

    public TripState getState() {
        return state;
    }
}
