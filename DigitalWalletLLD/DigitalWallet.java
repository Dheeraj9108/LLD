package DigitalWalletLLD;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DigitalWalletLLD.entities.Account;
import DigitalWalletLLD.entities.Transaction;
import DigitalWalletLLD.entities.User;
import DigitalWalletLLD.enums.Currency;
import DigitalWalletLLD.utility.CurrencyConverter;

public class DigitalWallet {
    private static DigitalWallet INSTANCE;
    private Map<String, User> users;
    private Map<String, Account> accounts;

    private DigitalWallet(){
        this.users = new HashMap<>();
        this.accounts = new HashMap<>();
    }

    public void addUser(User user){
        users.put(user.getId(), user);
    }

    public void addAccount(Account account){
        accounts.put(account.getAccNumber(), account);
        account.getUser().addAccount(account);
    }

    public void transferAmount(BigDecimal amount, Account srcAcc, Account destAcc, Currency currency){
        if(srcAcc.getCurrency() != currency){
            amount = CurrencyConverter.convert(amount, currency, srcAcc.getCurrency());
        }
        srcAcc.withdraw(amount);

        if(destAcc.getCurrency() != srcAcc.getCurrency()){
            amount = CurrencyConverter.convert(amount, srcAcc.getCurrency(), destAcc.getCurrency());
        }

        destAcc.deposit(amount);
        Transaction transaction = new Transaction(srcAcc, destAcc, amount, currency);
        srcAcc.addTransaction(transaction);
        destAcc.addTransaction(transaction);

        System.out.println("Amount Transfer Succesfull");
    }

    public List<Transaction> getTransactions(String accountId){
        Account account = accounts.get(accountId);
        return account.getTransactions();
    }

    public static DigitalWallet getInstance(){
        if(INSTANCE == null){
            synchronized(DigitalWallet.class){
                if(INSTANCE == null){
                    INSTANCE = new DigitalWallet();
                }
            }
        }
        return INSTANCE;
    }
}
