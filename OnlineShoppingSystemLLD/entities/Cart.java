package OnlineShoppingSystemLLD.entities;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final Map<String,CartItem> map = new HashMap<>(); 

    public void addItem(Product product, int qty){
        if(map.containsKey(product.getId())){
            map.get(product.getId()).increment(qty);
        } else {
            map.put(product.getId(),new CartItem(product, qty));
        }
        System.out.println("Product added to cart");
    }

    public void remove(Product product){
        map.remove(product.getId());
    }

    public double getTotalPrice(){
        return map.values().stream().mapToDouble(item->item.getTotalPrice()).sum();
    }

    public Map<String, CartItem> getMap() {
        return map;
    }
}
