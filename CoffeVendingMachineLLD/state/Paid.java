package CoffeVendingMachineLLD.state;

import CoffeVendingMachineLLD.CoffeeVendingMachine;
import CoffeVendingMachineLLD.decorator.Coffee;

public class Paid implements CoffeeVendingMachineState{

    @Override
    public void selectCoffee(CoffeeVendingMachine machine, Coffee coffee) {
    }

    @Override
    public void insertMoney(int amount, CoffeeVendingMachine machine, Coffee coffee) {
    }

    @Override
    public void dispense(CoffeeVendingMachine machine, Coffee coffee) {
        if(!machine.getInventory().hasIngredients(coffee.getRecipe())){
            System.out.println("Ingredients not found");
            machine.setState(new OutofIngredients());
            machine.getState().cancel(machine);
        } else {
            System.out.println("Dispensing Coffee");
            coffee.process();
            machine.getInventory().removeIngredients(coffee.getRecipe());
            if(machine.getBalance() > coffee.getPrice()){
                System.out.println("Change returned: "+ (machine.getBalance() - coffee.getPrice()));
            }
            machine.reset();
        }
    }

    @Override
    public void cancel(CoffeeVendingMachine machine) {
    }
    
}
