package OnlineShoppingSystemLLD.observer;

import java.util.ArrayList;
import java.util.List;

import OnlineShoppingSystemLLD.entities.Order;

public abstract class Subject {
    List<OrderObserver> observers = new ArrayList<>();
    
    public void addObserver(OrderObserver observer){
        this.observers.add(observer);
    }

    public void notifyObservers(Order order){
        for(OrderObserver observer : observers){
            observer.update(order);
        }
    }
}
