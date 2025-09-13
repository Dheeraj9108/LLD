package CoffeVendingMachineLLD.template;

import java.util.Map;

import CoffeVendingMachineLLD.decorator.Coffee;
import CoffeVendingMachineLLD.enums.Ingredient;

public class Latte extends Coffee{

    @Override
    public int getPrice() {
        return 300;
    }

    @Override
    public Map<Ingredient, Integer> getRecipe() {
        return Map.of(Ingredient.MILK,1,Ingredient.SUGAR,1,Ingredient.WATER,1);
    }

    @Override
    public void addCondiments() {
        System.out.println("Water");
    }
}
