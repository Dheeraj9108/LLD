package OnlineShoppingSystemLLD.entities;

public class OrderItem {
    private String productId;
    private String productName;
    private double price;
    private int productQty;
    public OrderItem(String productId, String productName, double price, int productQty) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.productQty = productQty;
    }
    public String getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public double getPrice() {
        return price;
    }
    public int getProductQty() {
        return productQty;
    }
}
