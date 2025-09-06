import Entities.ParkingFloor;
import Entities.ParkingSpot;
import Vehicle.Car;
import Vehicle.Vehicle;
import Vehicle.VehicleSize;

public class ParkignLotLLDMain{
    public static void main(String[] args){
        ParkingLot parkingLot = ParkingLot.getInstance();
        ParkingFloor floor1 = new ParkingFloor(); 
        floor1.addSpot(new ParkingSpot(1, VehicleSize.SMALL));
        floor1.addSpot(new ParkingSpot(2, VehicleSize.MEDIUM));

        Vehicle car = new Car("V1",VehicleSize.MEDIUM);

        parkingLot.addFloor(floor1);

        floor1.displayAvailability();
        
        parkingLot.parkVehicle(car);
        
        floor1.displayAvailability();

        parkingLot.unParkVehicle(car);
    }
}