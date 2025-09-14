package ATMLLD.entites;

import java.util.HashMap;
import java.util.Map;

public class Account {
    String accountNumber;
    int balance;
    Map<String,Card> cards;

    public Account(String accountNumber, int balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
        cards = new HashMap<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public Map<String, Card> getCards() {
        return cards;
    }

    public void deposit(int amount){
        this.balance+=amount;
    }

    public void withdraw(int amount){
        this.balance-=amount;
    }
    
}
