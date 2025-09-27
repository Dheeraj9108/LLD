package HotelManagementSystemLLD.stratergy;

public class Card implements PaymentStratergy{

    @Override
    public boolean processPayment(double price) {
        System.out.println("Payment Successfull");
        return true;
    }
    
}
