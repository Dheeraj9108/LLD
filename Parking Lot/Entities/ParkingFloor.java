package Entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import Vehicle.Vehicle;
import Vehicle.VehicleSize;

public class ParkingFloor {
    String floorId;
    List<ParkingSpot> spots;

    public ParkingFloor(){
        this.floorId = UUID.randomUUID().toString();
        spots = new ArrayList<>();
    }

    public void addSpot(ParkingSpot spot){
        spots.add(spot);
    }

    public Optional<ParkingSpot> findAvailalableSpot(Vehicle vehicle){
        Optional<ParkingSpot> availableSpot = spots.stream().filter(spot-> !spot.isOccupied && spot.canVehicleFit(vehicle.getSize()))
        .sorted(Comparator.comparing(ParkingSpot::getVehicleSize)).findFirst();
        return availableSpot;
    }

    public void displayAvailability(){
        System.out.println("Available Spots in Floor " + floorId);
        Map<VehicleSize, Long> availabilityMap = spots.stream().filter(spot->!spot.isOccupied).collect(Collectors.groupingBy(ParkingSpot::getVehicleSize,Collectors.counting())); 
        for(VehicleSize size : VehicleSize.values()){
            System.out.println(size + " -> "+availabilityMap.get(size));
        }
    }
}
