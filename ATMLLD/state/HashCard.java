package ATMLLD.state;

import ATMLLD.ATMSystem;
import ATMLLD.enums.Operation;

public class HashCard implements ATMState{

    @Override
    public void insertCard(ATMSystem system, String cardNumber) {
    }

    @Override
    public void enterPin(ATMSystem system, String pin) {
        if(system.authenticate(pin)){
            system.setState(new SelectOperation());
            return;
        }
        ejectCard(system);
        System.out.println("Authentication failed");
    }

    @Override
    public void selectOperation(ATMSystem system, Operation operation, int... args) {
    }

    @Override
    public void ejectCard(ATMSystem system) {
        system.setSelectedCard(null);
        system.setState(new Idel());
    }
    
}
