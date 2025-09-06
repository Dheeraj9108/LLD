package Entities;

import java.util.Date;
import java.util.UUID;

import Vehicle.Vehicle;

public class ParkingTicket {
    String ticketId;
    Vehicle vehicle;
    ParkingSpot spot;
    Long entryTime;
    Long exitTime;

    public ParkingTicket(Vehicle vehicle, ParkingSpot spot){
        ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.spot = spot;
        entryTime = new Date().getTime();
    }

    public String getId(){
        return ticketId;
    }

    public void setExitTime(Long exitTime){
        this.exitTime = exitTime;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Long getEntryTime() {
        return entryTime;
    }

    public Long getExitTime() {
        return exitTime;
    }
    

}
