package ATMLLD.entites;

import ATMLLD.chainofresposibility.DispenseChain;

public class CashDispenser {
    private final DispenseChain dispenseChain;

    public CashDispenser(DispenseChain dispenseChain){
        this.dispenseChain = dispenseChain;
    }

    public void dispenseCash(int amount){
        dispenseChain.dispenseCash(amount);
    }

    public boolean canDispense(int amount){
        if(amount%10 != 0) return false;
        return this.dispenseChain.canDispense(amount);
    }
}
