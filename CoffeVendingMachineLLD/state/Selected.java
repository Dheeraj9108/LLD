package CoffeVendingMachineLLD.state;

import CoffeVendingMachineLLD.CoffeeVendingMachine;
import CoffeVendingMachineLLD.decorator.Coffee;

public class Selected implements CoffeeVendingMachineState{

    @Override
    public void selectCoffee(CoffeeVendingMachine machine, Coffee coffee) {
    }

    @Override
    public void insertMoney(int amount, CoffeeVendingMachine machine, Coffee coffee) {
        machine.setBalnace(amount);
        if(machine.getBalance() >= coffee.getPrice()){
            System.out.println("Sufficient amount received");
            machine.setState(new Paid());
            machine.getState().dispense(machine, coffee);
        }
    }

    @Override
    public void dispense(CoffeeVendingMachine machine, Coffee coffee) {
    }

    @Override
    public void cancel(CoffeeVendingMachine machine) {
    }
    
}
