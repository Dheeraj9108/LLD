package UberLLD.entities;

import UberLLD.enums.DriverStatus;

public class Driver extends User{

    private Vehicle vechile;
    private Location curLocation;
    private DriverStatus status;

    public Driver(String name, String contact,Location location, Vehicle vechile) {
        super(name,contact);
        this.curLocation = location;
        this.vechile = vechile;
        this.status = DriverStatus.ONLINE;
    }

    @Override
    public void onUpdate(Trip trip) {
        System.out.println("----[Notification] Driver------");
        System.out.printf("%s is the Trip status \n", trip.getStatus());
    }

    public Vehicle getVechile() {
        return vechile;
    }

    public void setLocation(Location location){
        this.curLocation = location;
    }

    public Location getCurLocation() {
        return curLocation;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status){
        this.status = status;
    }
    
}
