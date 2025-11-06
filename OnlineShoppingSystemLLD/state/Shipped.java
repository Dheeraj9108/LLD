package OnlineShoppingSystemLLD.state;

import OnlineShoppingSystemLLD.entities.Order;
import OnlineShoppingSystemLLD.enums.OrderStatus;

public class Shipped implements OrderState{

    @Override
    public void shipped(Order order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'shipped'");
    }

    @Override
    public void delivered(Order order) {
        System.out.println("Order Delivered");
        order.setState(new Delivered());
        order.setStatus(OrderStatus.DELIVERED);
    }

    @Override
    public void canceled(Order order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'canceled'");
    }
    
}
