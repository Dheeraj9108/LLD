package OnlineShoppingSystemLLD.state;

import OnlineShoppingSystemLLD.entities.Order;

public class Cancelled implements OrderState{

    @Override
    public void shipped(Order order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'shipped'");
    }

    @Override
    public void delivered(Order order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delivered'");
    }

    @Override
    public void canceled(Order order) {
        System.out.println("Already cancelled");
    }
    
}
