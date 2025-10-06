package SplitwiseLLD.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import SplitwiseLLD.stratergy.SplitStrategry;

public class Expense {
    private String id;
    private String description;
    private double amount;
    private List<Split> splits;
    private LocalDate date;
    private User paidBy;

    public Expense(Builder builder) {
        this.id = UUID.randomUUID().toString();
        this.description = builder.description;
        this.amount = builder.amount;
        this.splits = builder.strategry.calculate(builder.users, builder.amounts, amount);
        this.paidBy = builder.paidBy;
        this.date = LocalDate.now();
    }

    public static class Builder {

        private String description;
        private double amount;
        private List<User> users;
        private List<Double> amounts;
        private SplitStrategry strategry;
        private User paidBy;

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setUser(List<User> users) {
            this.users = users;
            return this;
        }

        public Builder setAmount(List<Double> amounts) {
            this.amounts = amounts;
            return this;
        }

        public Builder setStratergy(SplitStrategry strategry) {
            this.strategry = strategry;
            return this;
        }

        public Builder setPaidBy(User user) {
            this.paidBy = user;
            return this;
        }

        public Expense Build() {
            return new Expense(this);
        }

    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public LocalDate getDate() {
        return date;
    }

    public User getPaidBy() {
        return paidBy;
    }
}
