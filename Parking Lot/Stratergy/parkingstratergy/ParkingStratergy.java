package Stratergy.parkingstratergy;

import java.util.List;
import java.util.Optional;

import Entities.ParkingFloor;
import Entities.ParkingSpot;
import Vehicle.Vehicle;

public interface ParkingStratergy {
    public Optional<ParkingSpot> findSot(List<ParkingFloor> floors, Vehicle vehicle);
}
