package UberLLD.state;

import UberLLD.entities.Driver;
import UberLLD.entities.Trip;

public class Completed implements TripState{

    @Override
    public void request(Trip trip) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'request'");
    }

    @Override
    public void assign(Trip trip, Driver driver) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assign'");
    }

    @Override
    public void start(Trip trip) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }

    @Override
    public void end(Trip trip) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'end'");
    }
    
}
