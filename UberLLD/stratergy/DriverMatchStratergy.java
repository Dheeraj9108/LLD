package UberLLD.stratergy;

import java.util.List;

import UberLLD.entities.Driver;
import UberLLD.entities.Location;
import UberLLD.enums.RideType;

public interface DriverMatchStratergy {
    public List<Driver> find(List<Driver> driverList, Location pick, Location drop, RideType type);
}
