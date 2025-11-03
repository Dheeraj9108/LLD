package UberLLD.state;


import UberLLD.entities.Driver;
import UberLLD.entities.Trip;
import UberLLD.enums.TripStatus;

public class Requested implements TripState{

    @Override
    public void request(Trip trip) {
    }

    @Override
    public void assign(Trip trip, Driver driver) {
        trip.setDriver(driver);
        trip.setState(new Assigned());
        trip.setStatus(TripStatus.ASSIGNED);
    }

    @Override
    public void start(Trip trip) {
    }

    @Override
    public void end(Trip trip) {
    }
    
}
