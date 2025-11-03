package UberLLD.state;

import UberLLD.entities.Driver;
import UberLLD.entities.Trip;
import UberLLD.enums.TripStatus;

public class Assigned implements TripState{

    @Override
    public void request(Trip trip) {
    }

    @Override
    public void assign(Trip trip, Driver driver) {
    }

    @Override
    public void start(Trip trip) {
        trip.setState(new InProgress());
        trip.setStatus(TripStatus.IN_PROGRESS);
    }

    @Override
    public void end(Trip trip) {
    }
    
}
