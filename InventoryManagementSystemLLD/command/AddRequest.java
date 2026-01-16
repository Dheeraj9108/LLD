package InventoryManagementSystemLLD.command;

import InventoryManagementSystemLLD.InventoryService;

public class AddRequest extends InventoryRequest{

    public AddRequest(String productId, int stock) {
        super(productId, stock);
    }

    @Override
    public void process(InventoryService service) {
        service.addStock(getProductId(), getStock());
    }
}
