package Entities;

import Vehicle.Vehicle;
import Vehicle.VehicleSize;

public class ParkingSpot {
    int spotId;
    Vehicle vehicle;
    VehicleSize size;
    boolean isOccupied;

    public ParkingSpot(int spotId, VehicleSize size){
        this.spotId = spotId;
        this.size = size;
    }

    public VehicleSize getVehicleSize(){
        return size;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void parkVehicle(Vehicle vehicle){
        this.isOccupied = true;
        this.vehicle = vehicle;
    }

    public void unParkVehicle(){
        this.isOccupied = false;
        vehicle = null;
    }

    public boolean canVehicleFit(VehicleSize size){
        switch (size) {
            case SMALL:
                return this.size == VehicleSize.SMALL;
            case MEDIUM:
                return this.size == VehicleSize.MEDIUM || this.size == VehicleSize.LARGE;
            case LARGE:
                return this.size == VehicleSize.LARGE;
            default : return false;
        }
    }
}
