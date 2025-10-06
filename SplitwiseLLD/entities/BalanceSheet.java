package SplitwiseLLD.entities;

import java.util.HashMap;
import java.util.Map;

public class BalanceSheet {
    private final User owner;
    private Map<User, Double> map;

    public BalanceSheet(User user) {
        this.owner = user;
        map = new HashMap<>();
    }

    public Map<User, Double> getBalances() {
        return map;
    }

    public void adjustBalanceSheet(User other, Double amount) {
        map.merge(other, amount, Double::sum);
    }

    public User getOwner() {
        return owner;
    }

    public Map<User, Double> getMap() {
        return map;
    }

    public void showBalanceSheet() {
        System.out.println("Balance Sheet for" + owner.getName());
        for (Map.Entry<User, Double> row : map.entrySet()) {
            User user = row.getKey();
            Double amount = row.getValue();
            if (amount > 0) {
                System.out.printf("%s owes %s \n", user.getName(), amount);
            } else {
                System.out.printf("%s owed %s to %s \n", owner.getName(), amount, user.getName());
            }
        }
    }
}
