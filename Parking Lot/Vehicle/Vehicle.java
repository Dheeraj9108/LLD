package Vehicle;

public abstract class Vehicle {
    String licenseNumber ;
    VehicleSize size;
    public Vehicle(String licenseNumber, VehicleSize size){
        this.licenseNumber = licenseNumber;
        this.size = size;
    }

    public VehicleSize getSize(){
        return size;
    }

    public String getLicenseNumber(){
        return licenseNumber;
    }
}