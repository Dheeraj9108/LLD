package CoffeVendingMachineLLD;

import CoffeVendingMachineLLD.decorator.Coffee;
import CoffeVendingMachineLLD.enums.CoffeeType;
import CoffeVendingMachineLLD.template.Cappuccino;
import CoffeVendingMachineLLD.template.Expresso;
import CoffeVendingMachineLLD.template.Latte;

public class CoffeeFactory {
    public static Coffee createCoffee(CoffeeType type){
        switch (type) {
            case LATTE: return new Latte();
            case EXPRESSO: return new Expresso();
            case CAPPUCCINO: return new Cappuccino();
            default: return new Expresso();
        }
    }    
}
