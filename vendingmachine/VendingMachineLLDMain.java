package vendingmachine;

import vendingmachine.entites.Item;
import vendingmachine.enums.Coin;

public class VendingMachineLLDMain{
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();
        
        Item item1 = new Item("A","Bingo Lays",5);
        Item item2 = new Item("B","Pizza",10);
        Item item3 = new Item("C","Biryani",25);

        vendingMachine.addItem(item1, 3);
        vendingMachine.addItem(item2, 1);
        vendingMachine.addItem(item3, 2);

        vendingMachine.selectItem(item1);
        vendingMachine.insertCoin(Coin.PENNY);
        vendingMachine.dispense();
    }
}