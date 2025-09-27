package HotelManagementSystemLLD.stratergy;

public class Cash implements PaymentStratergy{

    @Override
    public boolean processPayment(double price) {
        System.out.println("Payment Successfull.");
        return true;
    }
    
}
