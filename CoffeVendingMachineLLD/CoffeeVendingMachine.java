package CoffeVendingMachineLLD;

import java.util.List;

import CoffeVendingMachineLLD.decorator.Coffee;
import CoffeVendingMachineLLD.decorator.ExtraHoney;
import CoffeVendingMachineLLD.decorator.ExtraSugar;
import CoffeVendingMachineLLD.enums.CoffeeType;
import CoffeVendingMachineLLD.enums.Ingredient;
import CoffeVendingMachineLLD.enums.Toppings;
import CoffeVendingMachineLLD.state.CoffeeVendingMachineState;
import CoffeVendingMachineLLD.state.Ready;

public class CoffeeVendingMachine {

    private static CoffeeVendingMachine INSTANCE;
    private int currBalance;
    private Coffee selectedCoffee;
    private CoffeeVendingMachineState state;
    private Inventory inventory;

    private CoffeeVendingMachine() {
        currBalance = 0;
        state = new Ready();
        inventory = new Inventory();
    }

    public static CoffeeVendingMachine getInstance() {
        if (INSTANCE == null) {
            synchronized (CoffeeVendingMachine.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CoffeeVendingMachine();
                }
            }
        }
        return INSTANCE;
    }

    public void setSelectedCoffee(Coffee coffee) {
        this.selectedCoffee = coffee;
    }

    public Coffee getSelectedCoffee() {
        return selectedCoffee;
    }

    public void setBalnace(int amount) {
        this.currBalance += amount;
    }

    public int getBalance() {
        return this.currBalance;
    }

    public CoffeeVendingMachineState getState() {
        return this.state;
    }

    public void setState(CoffeeVendingMachineState state) {
        this.state = state;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void reset() {
        selectedCoffee = null;
        currBalance = 0;
        setState(new Ready());
    }

    public void addStock(Ingredient ingredient, int qty) {
        inventory.addStock(ingredient, qty);
    }

    public void selectCoffee(CoffeeType coffeeType, List<Toppings> toppings) {
        Coffee coffee = CoffeeFactory.createCoffee(coffeeType);

        for (Toppings topping : toppings) {
            switch (topping) {
                case EXTRA_SUGAR:
                    coffee = new ExtraSugar(coffee);
                    break;
                case EXTRA_HONEY:
                    coffee = new ExtraHoney(coffee);
                default:
                    break;
            }
        }
        state.selectCoffee(this, coffee);
    }

    public void insertMoney(int amount) {
        state.insertMoney(amount, this, selectedCoffee);
    }

    public void cancel() {
        reset();
    }

    public void printStock(){
        inventory.printStock();
    }
}
