package vendingmachine;

import vendingmachine.state.Idle;
import vendingmachine.entites.Inventory;
import vendingmachine.entites.Item;
import vendingmachine.enums.Coin;
import vendingmachine.state.VendingMachineState;

public class VendingMachine {

    private static VendingMachine INSTANCE;
    int curBalance;
    String selectedItem;
    Inventory inventory;
    VendingMachineState state;

    private VendingMachine(){
        curBalance = 0;
        selectedItem = "";
        inventory = new Inventory();
        state = new Idle(this);
    }
    
    public static VendingMachine getInstance(){
        if(INSTANCE == null){
            synchronized(VendingMachine.class){
                if(INSTANCE == null){
                    INSTANCE = new VendingMachine();
                }
            }
        }
        return INSTANCE;
    }

    public void addItem(Item item,int quantity){
        inventory.addItem(item.getCode(), item, quantity);
    }

    public void selectItem(Item item){
        state.selectItem(item);
    }

    public void setSelectedItem(String code){
        selectedItem = code;
    }

    public void setState(VendingMachineState state){
        this.state = state;
    }

    public void insertCoin(Coin Coin){
        state.insertCoin(Coin);
    }

    public void dispense(){
        state.dispense();
    }

    public void dispenseItem(){
        Item item = inventory.getItem(selectedItem);
        if(curBalance >= item.getPrice()){
            inventory.removeItem(selectedItem,1);
            curBalance-=item.getPrice();
            System.out.println(item.getName()+" Dispenced");
            if(curBalance > 0 ){
                System.out.println("Returning Change "+curBalance);
            }
            reset();
        }
        System.out.println("Insufficient amount");
    }

    public void cancel(){
        if(curBalance > 0 ){
            refund();
        }
        System.out.println("Canceled");
    }

    public void reset(){
        curBalance = 0;
        setState(new Idle(INSTANCE));
    }

    public void refund(){
        System.out.println("Amount Refunding");
    }

    public void addBalance(int amount){
        curBalance+=amount;
    }

    public int getCurBalance(){
        return curBalance;
    }

    public String getSelectedItem(){
        return selectedItem;
    }

    public Inventory getInventory(){
        return inventory;
    }
}
