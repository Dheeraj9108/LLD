package OnlineShoppingSystemLLD.entities;

import java.util.UUID;

import OnlineShoppingSystemLLD.enums.ProductCategory;

public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private ProductCategory category;
    public Product(String name, String description, double price, ProductCategory category) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public ProductCategory getCategory() {
        return category;
    }

}
