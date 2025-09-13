package vendingmachine.state;

import vendingmachine.VendingMachine;
import vendingmachine.entites.Item;
import vendingmachine.enums.Coin;

public class HashMoney extends VendingMachineState{

    public HashMoney(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(Item item) {
        System.out.println("Item Already Selected");
    }

    @Override
    public void insertCoin(Coin coin) {
       System.out.println("Suffcient Amoutn is Already received");
    }

    @Override
    public void dispense() {
        vendingMachine.dispenseItem();
        vendingMachine.setState(new Dispense(vendingMachine));
    }

    @Override
    public void refund() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'refund'");
    }
    
}
