package CoffeVendingMachineLLD;

import java.util.HashMap;
import java.util.Map;

import CoffeVendingMachineLLD.enums.Ingredient;

public class Inventory {

    Map<Ingredient, Integer> stock = new HashMap<>();

    public void addStock(Ingredient ingredient, int qty) {
        stock.put(ingredient, stock.getOrDefault(ingredient, 0) + qty);
    }

    public boolean hasIngredients(Map<Ingredient, Integer> recipe) {
        System.out.println(recipe);
        return recipe.entrySet().stream()
                .allMatch(entry -> stock.getOrDefault(entry.getKey(), 0) >= recipe.get(entry.getKey()));
    }

    public void removeIngredients(Map<Ingredient, Integer> recipe) {
        recipe.forEach((key,value) -> stock.put(key, stock.getOrDefault(key, 0) - recipe.get(key)));
    }

    public void printStock(){
        System.out.println("---------Stock---------");
        stock.forEach((key,val)-> System.out.println(key+" -> " + val));
    }
}
