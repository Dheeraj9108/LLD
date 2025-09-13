package CoffeVendingMachineLLD.decorator;

import java.util.Map;

import CoffeVendingMachineLLD.enums.Ingredient;

public abstract class Coffee {
    private String coffeeType = "";

    public void process(){
        grindBeans();
        brew();
        addCondiments();
        pourIntoCups();
    }

    public void grindBeans(){}
    public void brew(){}
    public void pourIntoCups(){}

    public String getCoffeType(){
        return this.coffeeType;
    }

    public abstract int getPrice();
    public abstract Map<Ingredient,Integer> getRecipe();
    public abstract void addCondiments();

    public void prepare() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'prepare'");
    }
}
