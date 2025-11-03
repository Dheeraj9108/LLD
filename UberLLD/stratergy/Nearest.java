package UberLLD.stratergy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import UberLLD.entities.Driver;
import UberLLD.entities.Location;
import UberLLD.enums.DriverStatus;
import UberLLD.enums.RideType;

public class Nearest implements DriverMatchStratergy {
    private final double MAX = 5.0;

    @Override
    public List<Driver> find(List<Driver> driverList, Location pick, Location drop, RideType type) {
        return driverList.stream()
                .filter(driver -> driver.getStatus() == DriverStatus.ONLINE)
                .filter(driver -> driver.getVechile().getType() == type)
                .filter(driver -> pick.distanceTo(driver.getCurLocation()) <= MAX)
                .sorted(Comparator.comparingDouble(driver->pick.distanceTo(driver.getCurLocation())))
                .collect(Collectors.toList());
    }

}
