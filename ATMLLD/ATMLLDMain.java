package ATMLLD;

import ATMLLD.enums.Operation;

public class ATMLLDMain {
    public static void main(String[] args) {
        ATMSystem system = ATMSystem.getInstance();

        // system.insertCard("c1");
        // system.enterPin("1234");
        // system.selectOperation(Operation.CHECK_BALANCE);

        system.insertCard("c1");
        system.enterPin("1234");
        system.selectOperation(Operation.WITHDRAW,220);

        // system.insertCard("c1");
        // system.enterPin("123");
    }
}
