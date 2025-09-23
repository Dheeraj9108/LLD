package CarRentalSystemLLD.entites;

import CarRentalSystemLLD.enums.CarType;

public class Car {
    private String oem;
    private String model;
    private String year;
    private double price;
    private CarType type;
    private String plateNumber;
    private boolean isAvailable;

    public Car(String oem, String model, String year, String plateNumber, double price, CarType type){
        this.oem = oem;
        this.model = model;
        this.year = year;
        this.plateNumber = plateNumber;
        this.price = price;
        this.type = type;
        isAvailable = true;
    }

    public String getOem() {
        return oem;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public CarType getType() {
        return type;
    }

    public String getPlateNumber() {
        return plateNumber;
    } 

    public boolean isAvailable(){
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }
}
