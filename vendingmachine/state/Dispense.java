package vendingmachine.state;

import vendingmachine.VendingMachine;
import vendingmachine.entites.Item;
import vendingmachine.enums.Coin;

public class Dispense extends VendingMachineState{

    public Dispense(VendingMachine vendingMachine) {
        super(vendingMachine);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void selectItem(Item item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectItem'");
    }

    @Override
    public void insertCoin(Coin coin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertCoin'");
    }

    @Override
    public void dispense() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispense'");
    }

    @Override
    public void refund() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'refund'");
    }
    
}
