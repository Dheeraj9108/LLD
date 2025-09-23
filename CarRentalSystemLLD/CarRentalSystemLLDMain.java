package CarRentalSystemLLD;

import java.time.LocalDate;
import java.util.List;

import CarRentalSystemLLD.entites.Car;
import CarRentalSystemLLD.entites.Customer;
import CarRentalSystemLLD.entites.Reservation;
import CarRentalSystemLLD.enums.CarType;

public class CarRentalSystemLLDMain {
    public static void main(String[] args) {
        CarRentalSystem system = CarRentalSystem.getInstance();
        
        Car c1 = new Car("Toyota", "Camry", "2025", "112Ad", 30, CarType.SEDAN);
        Car c2 = new Car("Ford", "Mustang", "2025", "225ta", 400, CarType.SUV);

        system.addCar(c1);
        system.addCar(c2);
        
        List<Car> cars = system.search("Ford", "Mustang", LocalDate.now(), LocalDate.ofEpochDay(2));
        Customer cus = new Customer("Cus1", "99880088", "aas33456");
        Reservation reservation = system.createReservation(cars.get(0), cus, LocalDate.now(), LocalDate.now().plusDays(2));
        System.out.println(system.processPayment(reservation.getId()));
        system.cancelReservation(reservation.getId());
    }
}
