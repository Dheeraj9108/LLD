package MovieBookingSystemLLD.strategry;

import java.util.List;

import MovieBookingSystemLLD.entities.Seat;


public class Weekend implements PricingStrategry{

    @Override
    public double calculate(List<Seat> seats) {
        return seats.stream().mapToDouble(seat->seat.getType().getPrice()).sum();
    }
}
