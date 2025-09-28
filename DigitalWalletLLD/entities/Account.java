package DigitalWalletLLD.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import DigitalWalletLLD.enums.Currency;

public class Account {
    private String accNumber;
    private User user;
    private BigDecimal balance;
    private Currency currency;
    List<Transaction> transactions;
    
    public Account(User user, BigDecimal balance, Currency currency) {
        this.accNumber = UUID.randomUUID().toString();
        this.user = user;
        this.balance = balance;
        this.currency = currency;
        transactions = new ArrayList<>();
    }

    public void deposit(BigDecimal amount){
        balance.add(amount);
    }

    public void withdraw(BigDecimal amount){
        if(balance.compareTo(amount) >= 0){
            balance.subtract(amount);
            return ;
        } 
        System.out.println("Insufficient Balance");
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public String getAccNumber() {
        return accNumber;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
