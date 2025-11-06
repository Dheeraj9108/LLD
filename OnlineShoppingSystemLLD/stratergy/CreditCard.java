package OnlineShoppingSystemLLD.stratergy;

public class CreditCard implements PaymentStratergy{

    @Override
    public void pay(double amount) {
        System.out.println("Payment done ");
    }
    
}
