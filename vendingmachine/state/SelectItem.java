package vendingmachine.state;

import vendingmachine.VendingMachine;
import vendingmachine.entites.Item;
import vendingmachine.enums.Coin;

public class SelectItem  extends VendingMachineState{

    public SelectItem(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(Item item) {
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addBalance(coin.getValue());
        Item item = vendingMachine.getInventory().getItem(vendingMachine.getSelectedItem());
        if(vendingMachine.getCurBalance() >= item.getPrice()){
            vendingMachine.setState(new Dispense(vendingMachine));
            System.out.println("Sufficient Amout Received");
        }
    }

    @Override
    public void dispense() {
    }

    @Override
    public void refund() {
    }

}
