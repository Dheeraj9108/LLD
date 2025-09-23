package CarRentalSystemLLD.stratergy;

import CarRentalSystemLLD.entites.Reservation;

public interface PaymentStratergy {
    public double processPayment(Reservation reservation);
    
}
