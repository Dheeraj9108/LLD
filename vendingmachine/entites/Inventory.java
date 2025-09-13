package vendingmachine.entites;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    Map<String,Integer> stockMap = new HashMap<>();
    Map<String, Item> itemMap = new HashMap<>();
    
    public void addItem(String code,Item item, int quantity){
        stockMap.put(code,quantity);
        itemMap.put(code,item);
    }

    public void removeItem(String code, int quantity){
        stockMap.put(code,stockMap.get(code) - quantity);
        if(stockMap.get(code) == 0){
            stockMap.remove(code);
        } 
    }

    public Item getItem(String code){
        return itemMap.get(code);   
    }

    public boolean isAvailable(String code){
        return stockMap.containsKey(code);
    }
}
