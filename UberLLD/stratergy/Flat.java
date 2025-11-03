package UberLLD.stratergy;

import UberLLD.entities.Location;
import UberLLD.enums.RideType;

public class Flat implements PriceStratergy{
    private final double BASE = 5.0;
    private final double PER = 1.5;

    @Override
    public double calculate(RideType rideType, Location pick, Location drop) {
        return BASE + pick.distanceTo(drop) * PER;
    }
}
