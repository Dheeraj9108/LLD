package FoodDeliverySystemLLD.entities;

public class OrderItem {
    
    private int qty;
    private MenuItem item;
    
    public OrderItem(MenuItem item,int qty) {
        this.qty = qty;
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public MenuItem getItem() {
        return item;
    }
    
}
