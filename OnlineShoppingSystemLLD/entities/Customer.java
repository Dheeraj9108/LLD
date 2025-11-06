package OnlineShoppingSystemLLD.entities;

import OnlineShoppingSystemLLD.observer.OrderObserver;

public class Customer implements OrderObserver {
    private String id;
    private String name;
    private String email;
    private Address address;
    private Cart cart;

    public Customer(String id, String name, String email, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.cart = new Cart();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Cart getCart() {
        return cart;
    }

    @Override
    public void update(Order order) {
        System.out.printf("Notification to %s order status %s \n", name, order.getStatus());
    }
}
