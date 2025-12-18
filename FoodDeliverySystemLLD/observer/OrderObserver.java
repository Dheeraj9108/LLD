package FoodDeliverySystemLLD.observer;

import FoodDeliverySystemLLD.entities.Order;

public interface OrderObserver {
    public void onUpdate(Order order);
}
