package HotelManagementSystemLLD.service;

import HotelManagementSystemLLD.stratergy.Card;
import HotelManagementSystemLLD.stratergy.PaymentStratergy;

public class PaymentService {
    private PaymentStratergy paymentStratergy;

    public PaymentService() {
        this.paymentStratergy = new Card();
    }

    public void processPayment(double amount){
        paymentStratergy.processPayment(amount);
    }
    
}
