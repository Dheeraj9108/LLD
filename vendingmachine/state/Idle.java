package vendingmachine.state;

import vendingmachine.VendingMachine;
import vendingmachine.entites.Item;
import vendingmachine.enums.Coin;

public class Idle extends VendingMachineState{

    public Idle(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(Item item) {
        if(vendingMachine.getInventory().isAvailable(item.getCode())){
            vendingMachine.setSelectedItem(item.getCode());
            vendingMachine.setState(new SelectItem(vendingMachine));
            return;
        }
        System.out.println("Selected Item is Out-of-Stock");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select the Item");
    }

    @Override
    public void dispense() {
        System.out.println("Please select the Item");
    }

    @Override
    public void refund() {
        System.out.println("Please select the Item");
    }
    
}
