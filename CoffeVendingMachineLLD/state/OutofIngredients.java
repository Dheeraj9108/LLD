package CoffeVendingMachineLLD.state;

import CoffeVendingMachineLLD.CoffeeVendingMachine;
import CoffeVendingMachineLLD.decorator.Coffee;

public class OutofIngredients implements CoffeeVendingMachineState{

    @Override
    public void selectCoffee(CoffeeVendingMachine machine, Coffee coffee) {
    }

    @Override
    public void insertMoney(int amount, CoffeeVendingMachine machine, Coffee coffee) {
    }

    @Override
    public void dispense(CoffeeVendingMachine machine, Coffee coffee) {
    }

    @Override
    public void cancel(CoffeeVendingMachine machine) {
        machine.reset();
    }
    
}
