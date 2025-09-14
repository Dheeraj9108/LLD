package ATMLLD.state;

import ATMLLD.ATMSystem;
import ATMLLD.enums.Operation;

public class SelectOperation implements ATMState {

    @Override
    public void insertCard(ATMSystem system, String cardNumber) {
    }

    @Override
    public void enterPin(ATMSystem system, String pin) {
    }

    @Override
    public void selectOperation(ATMSystem system, Operation operation, int... args) {
        switch (operation) {
            case CHECK_BALANCE:
                int balance = system.getBalance();
                System.out.println(balance);
                break;
            case WITHDRAW:
                int amount = args[0];
                if(system.getService().getBalance(system.getSelectedCard()) < amount){
                    System.out.println("Insufficient Account Balance");
                    return;
                }
                
                if(!system.canDispense(amount)){
                    System.out.println("Insufficient Balance ATM");
                    return;
                }

                system.withdraw(amount);

                system.dispenseCash(amount);
                ejectCard(system);
                break;
            case DEPOSIT:
                int amountToDeposit = args[0];
                system.deposit(amountToDeposit);
                ejectCard(system);
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }
    }

    @Override
    public void ejectCard(ATMSystem system) {
        system.setSelectedCard(null);
        system.setState(new Idel());
    }

}
