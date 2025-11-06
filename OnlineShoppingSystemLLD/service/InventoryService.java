package OnlineShoppingSystemLLD.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import OnlineShoppingSystemLLD.entities.OrderItem;
import OnlineShoppingSystemLLD.entities.Product;

public class InventoryService {
    private final Map<String, Integer> map = new HashMap<>();

    public void addStock(Product product, int qty){
        map.put(product.getId(), map.getOrDefault(product.getId(), 0)+qty);
    }

    public void updateStock(List<OrderItem> orders){
        for(OrderItem item:orders){
            if(map.getOrDefault(item.getProductId(), 0) < item.getProductQty()){
                System.out.println("Insufficient stock");
            }
        }

        for(OrderItem item:orders){
            map.put(item.getProductId(), map.get(item.getProductId()) - item.getProductQty());
        }
    }
}
