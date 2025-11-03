package UberLLD.stratergy;

import UberLLD.entities.Location;
import UberLLD.enums.RideType;

public interface PriceStratergy {
    public double calculate(RideType rideType,Location pick, Location drop);
}
