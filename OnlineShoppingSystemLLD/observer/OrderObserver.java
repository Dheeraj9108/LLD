package OnlineShoppingSystemLLD.observer;

import OnlineShoppingSystemLLD.entities.Order;

public interface OrderObserver {
    public void update(Order order);
}
