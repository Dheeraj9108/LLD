package InventoryManagementSystemLLD;

import java.util.HashMap;
import java.util.Map;

import InventoryManagementSystemLLD.entites.InventoryItem;

public class InventoryRepo {
    private  Map<String,InventoryItem> repo = new HashMap<>();

    public void addProduct(String productId,InventoryItem item){
        repo.put(productId,item);
    }

    public InventoryItem getProduct(String productId){
        return repo.get(productId);
    }
}