package FoodDeliverySystemLLD.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import FoodDeliverySystemLLD.enums.OrderStatus;
import FoodDeliverySystemLLD.observer.OrderObserver;

public class Order {

    private String id;
    private Customer customer;
    private List<OrderItem> items;
    private Restaurant restaurant;
    private List<OrderObserver> observers;
    private DeliveryAgent agent;
    private OrderStatus status;

    public Order(Customer customer, Restaurant restaurant, List<OrderItem> items){
        this.id = UUID.randomUUID().toString();
        this.customer = customer;
        this.restaurant = restaurant;
        this.items = items;
        status = OrderStatus.PENDING;
        observers = new ArrayList<>();
        addObserver(restaurant);
        addObserver(customer);
    }

    public void addObserver(OrderObserver observer){
        observers.add(observer);
    }

    public void notifyObservers(){
        for(OrderObserver observer: observers){
            observer.onUpdate(this);
        }
    }

    public void setStatus(OrderStatus status){
        this.status = status;
        notifyObservers();
    }

    public void assignAgent(DeliveryAgent agent){
        this.agent = agent;
        agent.setAvailability(false);
        addObserver(agent);
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<OrderObserver> getObservers() {
        return observers;
    }

    public DeliveryAgent getAgent() {
        return agent;
    }

    public OrderStatus getStatus() {
        return status;
    }

}
