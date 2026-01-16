package InventoryManagementSystemLLD.command;

import InventoryManagementSystemLLD.InventoryService;

public abstract class InventoryRequest {
    private String productId;
    private int stock;
    public InventoryRequest(String productId,int stock) {
        this.stock = stock;
        this.productId = productId;
    }

    public abstract void process(InventoryService service);

    public String getProductId() {
        return productId;
    }

    public int getStock() {
        return stock;
    }
}
