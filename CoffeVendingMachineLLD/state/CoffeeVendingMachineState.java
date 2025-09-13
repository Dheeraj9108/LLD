package CoffeVendingMachineLLD.state;

import CoffeVendingMachineLLD.CoffeeVendingMachine;
import CoffeVendingMachineLLD.decorator.Coffee;

public interface CoffeeVendingMachineState {
    public void selectCoffee(CoffeeVendingMachine machine, Coffee coffee);
    public void insertMoney(int amount, CoffeeVendingMachine machine, Coffee coffee);
    public void dispense(CoffeeVendingMachine machine, Coffee coffee);
    public void cancel(CoffeeVendingMachine machine);
}
