package OnlineShoppingSystemLLD.entities;

public class CartItem {

    private final Product product;
    private int qty;

    public CartItem(Product product, int qty) {
        this.product = product;
        this.qty = qty;
    }

    public Product getProduct() {
        return product;
    }

    public int getQty() {
        return qty;
    }

    public void increment(int amount) {
        qty += amount;
    }

    public double getTotalPrice() {
        return product.getPrice() * qty;
    }
}
