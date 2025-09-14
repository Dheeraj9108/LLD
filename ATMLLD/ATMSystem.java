package ATMLLD;

import ATMLLD.chainofresposibility.Note100;
import ATMLLD.chainofresposibility.Note20;
import ATMLLD.chainofresposibility.Note50;
import ATMLLD.chainofresposibility.NoteDispenser;
import ATMLLD.entites.BankService;
import ATMLLD.entites.Card;
import ATMLLD.entites.CashDispenser;
import ATMLLD.enums.Operation;
import ATMLLD.state.ATMState;
import ATMLLD.state.Idel;

public class ATMSystem {

    private static ATMSystem INSTANCE;
    private ATMState state;
    private Card selectedCard;
    private BankService bankService;
    private CashDispenser cashDispenser;

    private ATMSystem(){
        selectedCard = null;
        bankService = new BankService();
        state = new Idel();
        NoteDispenser note100 = new Note100(2);
        NoteDispenser note50 = new Note50(2);
        NoteDispenser note20 = new Note20(2);

        note100.setNextChain(note50);
        note50.setNextChain(note20);
        cashDispenser = new CashDispenser(note100);
    }

    public static ATMSystem getInstance(){
        if(INSTANCE == null){
            synchronized(ATMSystem.class){
                if(INSTANCE == null){
                    INSTANCE = new ATMSystem();
                }
            }
        }
        return INSTANCE;
    }

    public ATMState getState() {
        return state;
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public BankService getService() {
        return bankService;
    }

    public void setState(ATMState state){
        this.state = state;
    }

    public void setSelectedCard(Card card){
        this.selectedCard = card;  
    }

    public void insertCard(String cardNumber){
        state.insertCard(INSTANCE, cardNumber);
    }

    public void enterPin(String pin){
        state.enterPin(INSTANCE, pin);
    }

    public void selectOperation(Operation operation,int... args){
        state.selectOperation(INSTANCE, operation, args);
    }

    public boolean authenticate(String pin){
        return bankService.authenticate(selectedCard, pin);
    } 

    public int getBalance(){
        return bankService.getBalance(selectedCard);
    }

    public boolean canDispense(int amount){
        return cashDispenser.canDispense(amount);
    }

    public void dispenseCash(int amount){
        cashDispenser.dispenseCash(amount);
    }

    public void withdraw(int amount){
        bankService.withdraw(selectedCard, amount);
    }

    public void deposit(int amount){
        bankService.deposit(selectedCard, amount);
    }

    public Card getCard(String cardNumber){
        return bankService.getCard(cardNumber);
    }
}
