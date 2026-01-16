package InventoryManagementSystemLLD;

import InventoryManagementSystemLLD.entites.InventoryItem;

public class InventoryService {

    private static InventoryService INSTANCE;
    
    private InventoryRepo repo;

    private InventoryService(InventoryRepo repo){
        this.repo = repo;
    }

    public static InventoryService getInstance(InventoryRepo repo){
        if(INSTANCE == null){
            synchronized(InventoryService.class){
                if(INSTANCE == null){
                    INSTANCE = new InventoryService(repo);
                }
            }
        }
        return INSTANCE;
    }

    public void addStock(String productId, int stock){
        InventoryItem item = repo.getProduct(productId);
        if(item!=null){
            item.addStock(stock);
        }
    }

    public void removeStock(String productId, int stock){
        InventoryItem item = repo.getProduct(productId);
        if(item!=null){
            if(item.getStock() < stock){    
                System.out.println("Not enough stock");
            } else {
                item.removeStock(stock);
            }
        }
    }

    public int checkStock(String productId){
        InventoryItem item = repo.getProduct(productId);
        return item.getStock();
    }
}
