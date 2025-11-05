package MovieBookingSystemLLD.entities;

import java.util.UUID;

import MovieBookingSystemLLD.enums.PaymentStatus;

public class Payment {
    private String id;
    private double amount;
    private String txnId;
    private PaymentStatus status;

    public Payment(double amount, String txnId, PaymentStatus status) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.txnId = txnId;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getTxnId() {
        return txnId;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
