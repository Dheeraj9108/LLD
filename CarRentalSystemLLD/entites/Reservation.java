package CarRentalSystemLLD.entites;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Reservation {
    private String id;
    private LocalDate starDate;
    private LocalDate endDate;
    private Car car;
    private Customer customer;
    private double totalPrice;

    public Reservation(LocalDate starDate, LocalDate endDate, Car car, Customer customer) {
        this.id = UUID.randomUUID().toString() ;
        this.starDate = starDate;
        this.endDate = endDate;
        this.car = car;
        this.customer = customer;
        this.totalPrice = calculate();
    }

    private double calculate(){
        long days = ChronoUnit.DAYS.between(starDate, endDate)+1;
        return days * car.getPrice(); 
    }

    public String getId() {
        return id;
    }

    public LocalDate getStarDate() {
        return starDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
