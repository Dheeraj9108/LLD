package CoffeVendingMachineLLD.state;

import CoffeVendingMachineLLD.CoffeeVendingMachine;
import CoffeVendingMachineLLD.decorator.Coffee;

public class Ready implements CoffeeVendingMachineState{

    @Override
    public void selectCoffee(CoffeeVendingMachine machine, Coffee coffee) {
        machine.setSelectedCoffee(coffee);
        machine.setState(new Selected());
    }

    @Override
    public void insertMoney(int amount, CoffeeVendingMachine machine, Coffee coffee) {
    }

    @Override
    public void dispense(CoffeeVendingMachine machine, Coffee coffee) {
    }

    @Override
    public void cancel(CoffeeVendingMachine machine) {
    }
    
}
