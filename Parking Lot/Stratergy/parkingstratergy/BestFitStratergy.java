package Stratergy.parkingstratergy;

import java.util.List;
import java.util.Optional;

import Entities.ParkingFloor;
import Entities.ParkingSpot;
import Vehicle.Vehicle;

public class BestFitStratergy implements ParkingStratergy{

    @Override
    public Optional<ParkingSpot> findSot(List<ParkingFloor> floors, Vehicle vehicle) {
        Optional<ParkingSpot> bestSpot = Optional.empty();
        for(ParkingFloor floor : floors){
            Optional<ParkingSpot> spot = floor.findAvailalableSpot(vehicle);
            if(spot.isPresent()){
                if(bestSpot.isEmpty())bestSpot = spot;
                else {
                    if(spot.get().getVehicleSize().ordinal() < bestSpot.get().getVehicleSize().ordinal()){
                        bestSpot = spot;
                    }
                }
            } 
        }
        return bestSpot;
    }
    
}
