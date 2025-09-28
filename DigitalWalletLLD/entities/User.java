package DigitalWalletLLD.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {

    private String id;
    private String name;
    private String email;
    List<Account> accounts;
    
    public User(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account acc){
        accounts.add(acc);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
