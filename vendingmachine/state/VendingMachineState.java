package vendingmachine.state;

import vendingmachine.VendingMachine;
import vendingmachine.entites.Item;
import vendingmachine.enums.Coin;

public abstract class VendingMachineState {
    VendingMachine vendingMachine;

    public VendingMachineState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public abstract void selectItem(Item item);
    public abstract void insertCoin(Coin coin);
    public abstract void dispense();
    public abstract void refund(); 
}
