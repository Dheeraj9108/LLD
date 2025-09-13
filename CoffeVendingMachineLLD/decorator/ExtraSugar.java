package CoffeVendingMachineLLD.decorator;

import java.util.HashMap;
import java.util.Map;

import CoffeVendingMachineLLD.enums.Ingredient;

public class ExtraSugar extends CoffeeDecorator{

    private final Map<Ingredient,Integer> ADDITIONAL_RECIPE = Map.of(Ingredient.MILK,1);

    public ExtraSugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getPrice() {
        return decoratedCoffee.getPrice() + 10;
    }

    @Override
    public Map<Ingredient, Integer> getRecipe() {
        Map<Ingredient,Integer> recipe = new HashMap<>(decoratedCoffee.getPrice());
        ADDITIONAL_RECIPE.forEach((key,value)->recipe.merge(key, value, Integer::sum));
        return recipe;
    }

    @Override
    public void addCondiments() {
        decoratedCoffee.addCondiments();
        System.out.println("Steamed Milk");
    }
}
