package FoodDeliverySystemLLD.entities;

public class MenuItem {
    private String id;
    private String name;
    private Double price;
    private boolean available;
    public MenuItem(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.available = true;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }
    public boolean isAvailable() {
        return available;
    }

}
