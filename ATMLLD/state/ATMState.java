package ATMLLD.state;

import ATMLLD.ATMSystem;
import ATMLLD.enums.Operation;

public interface ATMState {
    public void insertCard(ATMSystem system , String cardNumber);
    public void enterPin(ATMSystem system, String pin);
    public void selectOperation(ATMSystem system, Operation operation, int... args);
    public void ejectCard(ATMSystem system);
}
