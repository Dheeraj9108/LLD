package FoodDeliverySystemLLD.entities;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    Map<String,MenuItem> items;
    public Menu(){
        items = new HashMap<>();
    }

    public void addToMenu(MenuItem item){
        items.put(item.getId(),item);
    }

    public MenuItem getItem(String id){
        return items.get(id);
    }

    public Map<String, MenuItem> getItems() {
        return items;
    }
    
}
