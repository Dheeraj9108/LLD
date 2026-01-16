package InventoryManagementSystemLLD.command;

import InventoryManagementSystemLLD.InventoryService;

public class RemoveRequest extends InventoryRequest{

    public RemoveRequest(String productId, int stock) {
        super(productId, stock);
    }

    @Override
    public void process(InventoryService service) {
        service.removeStock(getProductId(), getStock());
    }
}
