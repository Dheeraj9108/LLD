package DigitalWalletLLD.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import DigitalWalletLLD.enums.Currency;

public class Transaction {
    private String id;
    private Account srcAcc;
    private Account destAcc;
    private BigDecimal amount;
    private Currency currency;
    private LocalDate timeStamp;
    
    public Transaction(Account srcAcc, Account destAcc, BigDecimal amount, Currency currency) {
        this.srcAcc = srcAcc;
        this.destAcc = destAcc;
        this.amount = amount;
        this.currency = currency;
        this.timeStamp = LocalDate.now();
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public Account getSrcAcc() {
        return srcAcc;
    }

    public Account getDestAcc() {
        return destAcc;
    }

    @Override
    public String toString() {
        return String.format("[Transaction Id]  : %s \n [From] : %s \n  [To] : %s \n [Amount] : %s\n [Currency] : %s\n" , id,srcAcc.getUser().getName(),destAcc.getUser().getName(),amount,currency);
    }
}
