package MovieBookingSystemLLD.strategry;

import java.util.UUID;

import MovieBookingSystemLLD.entities.Payment;
import MovieBookingSystemLLD.enums.PaymentStatus;

public class CreditCard implements PaymentStratergy{

    @Override
    public Payment pay(double amount) {
        System.out.println("Processing payment");
        return new Payment(amount, UUID.randomUUID().toString(), PaymentStatus.DONE);
    }
    
}
