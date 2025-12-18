package FoodDeliverySystemLLD.entities;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{

    private Address address;
    private List<Order> orders;

    public Customer(String name, String phone, Address address) {
        super(name, phone);
        this.address = address;
        orders = new ArrayList<>();
    }

    public void addOrderInHostory(Order order){
        this.orders.add(order);
    } 

    public Address getAddress() {
        return address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public void onUpdate(Order order) {
        System.out.printf("Notification for %s :: Order Status %s \n", getName(), order.getStatus());
    }
    
}
