package UberLLD.state;

import UberLLD.entities.Driver;
import UberLLD.entities.Trip;

public interface TripState {
    public void request(Trip trip);
    public void assign(Trip trip, Driver driver);
    public void start(Trip trip);
    public void end(Trip trip);
}
