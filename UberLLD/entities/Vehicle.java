package UberLLD.entities;

import UberLLD.enums.RideType;

public class Vehicle {
    private String number;
    private RideType type;
    private String model;
    public Vehicle(String number,String model, RideType type ) {
        this.number = number;
        this.type = type;
        this.model = model;
    }
    public String getNumber() {
        return number;
    }
    public RideType getType() {
        return type;
    }
    public String getModel() {
        return model;
    }
 
}
