package CarRentalSystemLLD;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CarRentalSystemLLD.entites.Car;
import CarRentalSystemLLD.entites.Customer;
import CarRentalSystemLLD.entites.Reservation;
import CarRentalSystemLLD.stratergy.Card;
import CarRentalSystemLLD.stratergy.PaymentStratergy;

public class CarRentalSystem {
    
    private static CarRentalSystem INSTANCE;
    private Map<String,Car> cars;
    private Map<String,Reservation> reservations;
    private PaymentStratergy paymentStratergy;

    private CarRentalSystem(){
        this.cars = new HashMap<>();
        this.reservations = new HashMap<>();
        this.paymentStratergy = new Card();
    }

    public static CarRentalSystem getInstance(){
        if(INSTANCE == null){
            synchronized(CarRentalSystem.class){
                if(INSTANCE == null){
                    INSTANCE = new CarRentalSystem();
                }
            }
        }
        return INSTANCE;
    }

    public void addCar(Car car){
        cars.put(car.getPlateNumber(),car);
    }

    public List<Car> search(String oem, String model, LocalDate startDate, LocalDate endDate){
        List<Car> list = new ArrayList<>();
        for(Car car : cars.values()){
            if(car.getOem().equals(oem) && car.getModel().equals(model)){
                if(isAvailable(car,startDate,endDate)){
                    list.add(car);
                }
            }
        }
        return list;
    }

    public boolean isAvailable(Car car, LocalDate start, LocalDate end){
        for(Reservation reservation: reservations.values()){
            if(reservation.getCar() == car){
                if(reservation.getStarDate().isBefore(start) && reservation.getEndDate().isAfter(end)) return false;
            }
        }
        return true;
    }

    public Reservation createReservation(Car car, Customer customer, LocalDate start, LocalDate end){
        Reservation reservation = new Reservation(start, end, car, customer);
        reservations.put(reservation.getId(), reservation);
        car.setIsAvailable(false);
        System.out.println("Reservation Created");
        return reservation;
    }

    public void cancelReservation(String reservationId){
        Reservation reservation = reservations.remove(reservationId);
        reservation.getCar().setIsAvailable(true);
        System.out.println("Reservation Canceled");
    }

    public double processPayment(String reservationId){
        Reservation reservation = reservations.get(reservationId);
        return paymentStratergy.processPayment(reservation);
    }
}
