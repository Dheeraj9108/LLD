package FoodDeliverySystemLLD.entities;

import java.util.UUID;

import FoodDeliverySystemLLD.observer.OrderObserver;

public class Restaurant implements OrderObserver{

    private String id;
    private String name;
    private Address address;
    private Menu menu;

    public Restaurant(String name, Address address) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.menu = new Menu();
    }

    @Override
    public void onUpdate(Order order) {
        System.out.printf("Notification to Restuarant %s :: Order status %s \n", name,order.getStatus());
    }

    public void addToMenu(MenuItem item){
        menu.addToMenu(item);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Menu getMenu() {
        return menu;
    }
    
}
