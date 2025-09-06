package Stratergy.feestratergy;

import java.util.HashMap;
import java.util.Map;

import Entities.ParkingTicket;
import Vehicle.VehicleSize;

public class VehicleBaseStratergy implements FeeStratergy{

    private Map<VehicleSize, Double> priceMap = new HashMap<>();

    public VehicleBaseStratergy(){
        priceMap.put(VehicleSize.SMALL, 10.0);
        priceMap.put(VehicleSize.MEDIUM, 20.0);
        priceMap.put(VehicleSize.LARGE, 30.0);
    }

    @Override
    public double calculateFee(ParkingTicket ticket) {
        Long duration = ticket.getExitTime() - ticket.getEntryTime();
        long hours = ((duration)/ 1000 * 60 * 60)+1;
        return priceMap.get(ticket.getVehicle().getSize()) * hours;
    }
    
}
