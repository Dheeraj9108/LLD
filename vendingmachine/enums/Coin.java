package vendingmachine.enums;

public enum Coin {
    PENNY(5),
    NICKEL(10),
    DIME(15);

    private final int value;

    Coin(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
