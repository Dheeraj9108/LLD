package ATMLLD.state;

import ATMLLD.ATMSystem;
import ATMLLD.entites.Card;
import ATMLLD.enums.Operation;

public class Idel implements ATMState{

    @Override
    public void insertCard(ATMSystem system, String cardNumber) {
        System.out.println("Card Inserted");
        Card existingCardDetails = system.getCard(cardNumber);
        if(existingCardDetails == null){
            System.out.println("Card Not found");
            return;
        }
        system.setSelectedCard(existingCardDetails);
        system.setState(new HashCard());
    }

    @Override
    public void enterPin(ATMSystem system, String pin) {
    }

    @Override
    public void selectOperation(ATMSystem system, Operation operation, int... args) {
    }

    @Override
    public void ejectCard(ATMSystem system) {
    }

}
