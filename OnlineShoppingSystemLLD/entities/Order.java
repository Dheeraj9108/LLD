package OnlineShoppingSystemLLD.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import OnlineShoppingSystemLLD.enums.OrderStatus;
import OnlineShoppingSystemLLD.observer.Subject;
import OnlineShoppingSystemLLD.state.OrderState;
import OnlineShoppingSystemLLD.state.Placed;

public class Order extends Subject{
    private String id;
    private Customer customer;
    private List<OrderItem> orderItems;
    private LocalDateTime date;
    private double totalAmount;
    private OrderState state;
    private OrderStatus status;
    public Order(Customer customer, List<OrderItem> orderItems, LocalDateTime date, double totalAmount) {
        this.id = UUID.randomUUID().toString();
        this.customer = customer;
        this.orderItems = orderItems;
        this.date = date;
        this.totalAmount = totalAmount;
        this.state = new Placed();
        this.status = OrderStatus.PLACED;
        addObserver(customer);
    }
    public String getId() {
        return id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public OrderState getState() {
        return state;
    }
    public OrderStatus getStatus() {
        return status;
    }

    public void setState(OrderState state){
        this.state = state;
        notifyObservers(this);
    }

    public void setStatus(OrderStatus status){
        this.status = status;
    }

    public void shipOrder(){
        state.shipped(this);    
    }
    
    public void deliverOrder(){
        state.delivered(this);    
    }
    
    public void cancelOrder(){
        state.canceled(this);    
    }

}
