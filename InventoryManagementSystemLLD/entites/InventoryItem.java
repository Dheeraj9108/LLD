package InventoryManagementSystemLLD.entites;

public class InventoryItem {
    
    private int stock;

    public InventoryItem(int stock) {
        this.stock = stock;
    }

    public synchronized void addStock(int stock){
        this.stock+=stock;
    }

    public synchronized void removeStock(int stock){
        this.stock-=stock;
    }

    public int getStock() {
        return stock;
    }
}   
