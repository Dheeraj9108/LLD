package OnlineShoppingSystemLLD.state;

import OnlineShoppingSystemLLD.entities.Order;

public interface OrderState {
    public void shipped(Order order);
    public void delivered(Order order);
    public void canceled(Order order);
}
