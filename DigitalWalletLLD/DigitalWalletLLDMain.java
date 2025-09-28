package DigitalWalletLLD;

import java.math.BigDecimal;
import java.util.List;

import DigitalWalletLLD.entities.Account;
import DigitalWalletLLD.entities.Transaction;
import DigitalWalletLLD.entities.User;
import DigitalWalletLLD.enums.Currency;

public class DigitalWalletLLDMain {
    public static void main(String[] args) {
        DigitalWallet digitalWallet = DigitalWallet.getInstance();

        User alice = new User("Alice", "alice@gmail.com");
        User bob = new User("Bob", "bob@gmail.com");

        Account aliceAccount = new Account(alice, new BigDecimal(110), Currency.USD);
        Account bobAccount = new Account(bob, new BigDecimal(110), Currency.JPY);

        digitalWallet.addUser(alice);
        digitalWallet.addUser(bob);

        digitalWallet.addAccount(aliceAccount);
        digitalWallet.addAccount(bobAccount);

        digitalWallet.transferAmount(new BigDecimal(20), aliceAccount, bobAccount, Currency.EUR);

        List<Transaction> transactions = digitalWallet.getTransactions(aliceAccount.getAccNumber());
        
        for(Transaction transaction : transactions){
            System.out.println(transaction);
        }
    }
}
