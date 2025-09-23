package CarRentalSystemLLD.stratergy;

import CarRentalSystemLLD.entites.Reservation;

public class Card implements PaymentStratergy{

    @Override
    public double processPayment(Reservation reservation) {
        return reservation.getTotalPrice();
    }
    
}
