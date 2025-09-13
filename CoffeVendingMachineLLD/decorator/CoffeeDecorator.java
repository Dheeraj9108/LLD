package CoffeVendingMachineLLD.decorator;

import java.util.Map;

import CoffeVendingMachineLLD.enums.Ingredient;

public abstract class CoffeeDecorator extends Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

     @Override
    public int getPrice() {
        return decoratedCoffee.getPrice();
    }

    @Override
    public Map<Ingredient, Integer> getRecipe() {
        return decoratedCoffee.getRecipe();
    }

    @Override
    public void addCondiments() {
        decoratedCoffee.addCondiments();
    }

    @Override
    public void prepare() {
        decoratedCoffee.prepare();
    }
}
