package UberLLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import UberLLD.entities.Driver;
import UberLLD.entities.Location;
import UberLLD.entities.Rider;
import UberLLD.entities.Trip;
import UberLLD.entities.Vehicle;
import UberLLD.enums.DriverStatus;
import UberLLD.enums.RideType;
import UberLLD.stratergy.DriverMatchStratergy;
import UberLLD.stratergy.PriceStratergy;

public class RideSharingService {
    private static RideSharingService INSATNCE;
    private Map<String, Rider> riders;
    private Map<String, Driver> drivers;
    private Map<String, Trip> trips;
    private DriverMatchStratergy driverStratergy;
    private PriceStratergy priceStratergy;

    private RideSharingService() {
        this.drivers = new HashMap<>();
        this.riders = new HashMap<>();
        this.trips = new HashMap<>();
    }

    public static RideSharingService getInstance() {
        if (INSATNCE == null) {
            synchronized (RideSharingService.class) {
                if (INSATNCE == null) {
                    INSATNCE = new RideSharingService();
                }
            }
        }
        return INSATNCE;
    }

    public void setDriverMatchStratergy(DriverMatchStratergy stratergy) {
        this.driverStratergy = stratergy;
    }

    public void setPriceStratergy(PriceStratergy stratergy) {
        this.priceStratergy = stratergy;
    }

    public Rider registerRider(String name, String contact) {
        Rider rider = new Rider(name, contact);
        riders.put(rider.getId(), rider);
        return rider;
    }

    public Driver registerDriver(String name, String contact, Vehicle vehicle, Location location) {
        Driver driver = new Driver(name, contact, location, vehicle);
        drivers.put(driver.getId(), driver);
        return driver;
    }

    public Trip requestRide(String riderId, Location pick, Location drop, RideType type) {
        Rider rider = riders.get(riderId);
        System.out.printf("%s requested ride", rider.getName());
        List<Driver> driverList = driverStratergy.find(new ArrayList<>(drivers.values()), pick, drop, type);
        if (driverList == null) {
            System.out.println("No Driver available");
            return null;
        }

        double price = priceStratergy.calculate(type, pick, drop);

        Trip trip = new Trip.TripBuilder()
                .setPick(pick)
                .setDrop(drop)
                .setRider(rider)
                .setFare(price)
                .build();

        for(Driver driver : drivers.values()){
            driver.onUpdate(trip);
        }

        trips.put(trip.getId(), trip);
        return trip;
    }

    public void acceptRequest(String driverId, String tripId){
        Driver driver = drivers.get(driverId);
        Trip trip = trips.get(tripId);
        driver.setStatus(DriverStatus.IN_TRIPE);
        trip.assignDriver(driver);
    }

    public void start(String tripId){
        Trip trip = trips.get(tripId);
        trip.start();
    }

    public void end(String tripId){
        Trip trip = trips.get(tripId);
        trip.end();
        Driver driver = trip.getDriver();
        driver.setLocation(trip.getDrop());
        driver.setStatus(DriverStatus.ONLINE);
        driver.addTripHistory(trip);
        Rider rider = trip.getRider();
        rider.addTripHistory(trip);
    }

}
