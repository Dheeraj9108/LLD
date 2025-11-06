package OnlineShoppingSystemLLD.state;

import OnlineShoppingSystemLLD.entities.Order;
import OnlineShoppingSystemLLD.enums.OrderStatus;

public class Placed implements OrderState {

    @Override
    public void shipped(Order order) {
        System.out.println("Order Shipped");
        order.setState(new Shipped());
        order.setStatus(OrderStatus.SHIPPED);
    }

    @Override
    public void delivered(Order order) {
    }

    @Override
    public void canceled(Order order) {
        System.out.println("Order Cancelled");
        order.setState(new Cancelled());
        order.setStatus(OrderStatus.CANCELED);
    }

}
