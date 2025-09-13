package CoffeVendingMachineLLD;

import java.util.List;

import CoffeVendingMachineLLD.enums.CoffeeType;
import CoffeVendingMachineLLD.enums.Ingredient;
import CoffeVendingMachineLLD.enums.Toppings;

public class CoffeeVendingMachineLLDMain {
    public static void main(String[] args) {
        CoffeeVendingMachine machine = CoffeeVendingMachine.getInstance();

        machine.addStock(Ingredient.BEANS, 1);
        machine.addStock(Ingredient.MILK, 1);
        machine.addStock(Ingredient.SUGAR, 1);
        machine.addStock(Ingredient.SYRUP, 1);
        machine.addStock(Ingredient.WATER, 1);

        machine.selectCoffee(CoffeeType.LATTE,List.of());
        machine.insertMoney(400);
        
        machine.printStock();
        machine.selectCoffee(CoffeeType.LATTE,List.of(Toppings.EXTRA_HONEY));
        machine.insertMoney(400);
    }    
}
