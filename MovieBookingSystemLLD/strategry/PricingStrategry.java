package MovieBookingSystemLLD.strategry;

import java.util.List;

import MovieBookingSystemLLD.entities.Seat;

public interface PricingStrategry {
    public double calculate(List<Seat> seats);
}
