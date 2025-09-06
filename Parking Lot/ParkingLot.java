import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import Entities.ParkingFloor;
import Entities.ParkingSpot;
import Entities.ParkingTicket;
import Stratergy.feestratergy.FeeStratergy;
import Stratergy.feestratergy.VehicleBaseStratergy;
import Stratergy.parkingstratergy.BestFitStratergy;
import Stratergy.parkingstratergy.ParkingStratergy;
import Vehicle.Vehicle;

public class ParkingLot {
    private static ParkingLot instance;
    private FeeStratergy feeStratergy;
    private ParkingStratergy parkingStratergy;
    List<ParkingFloor> floors;
    Map<String, ParkingTicket> activeTickets;

    private ParkingLot() {
        feeStratergy = new VehicleBaseStratergy();
        parkingStratergy = new BestFitStratergy();
        floors = new ArrayList<>();
        activeTickets = new HashMap<>();
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            synchronized (ParkingLot.class) {
                if (instance == null) {
                    instance = new ParkingLot();

                }
            }
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public Optional<ParkingTicket> parkVehicle(Vehicle vehicle) {
        Optional<ParkingSpot> optionalSpot = parkingStratergy.findSot(floors, vehicle);
        if (optionalSpot.isPresent()) {
            ParkingSpot spot = optionalSpot.get();
            spot.parkVehicle(vehicle);
            // genrate ticket
            ParkingTicket ticket = new ParkingTicket(vehicle, spot);
            activeTickets.put(vehicle.getLicenseNumber(), ticket);
            return Optional.of(ticket);
        }
        System.out.println("No Parking Spots Available");
        return Optional.empty();

    }

    public void unParkVehicle(Vehicle vehicle) {
        ParkingTicket ticket = activeTickets.getOrDefault(vehicle.getLicenseNumber(), null);
        if (ticket == null) {
            System.out.println("No Parking Info Found");
            return;
        }

        ParkingSpot spot = ticket.getSpot();
        spot.unParkVehicle();
        ticket.setExitTime(new Date().getTime());
        Double fee = feeStratergy.calculateFee(ticket);
        System.out.println("Please Pay the amout " + fee);
    }

}
