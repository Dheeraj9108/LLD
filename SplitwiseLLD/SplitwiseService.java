package SplitwiseLLD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import SplitwiseLLD.entities.Expense;
import SplitwiseLLD.entities.Group;
import SplitwiseLLD.entities.Split;
import SplitwiseLLD.entities.Transaction;
import SplitwiseLLD.entities.User;

public class SplitwiseService {
    private static SplitwiseService INSTANCE;
    private Map<String, User> users;
    private Map<String, Group> groups;

    private SplitwiseService() {
        users = new HashMap<>();
        groups = new HashMap<>();
    }

    public static SplitwiseService getInstance() {
        if (INSTANCE == null) {
            synchronized (SplitwiseService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SplitwiseService();
                }
            }
        }
        return INSTANCE;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public Map<String, Group> getGroups() {
        return groups;
    }

    public User addUser(String name, String email) {
        User user = new User(name, email);
        users.put(user.getId(), user);
        return user;
    }

    public Group addGroup(String name, List<User> users) {
        Group group = new Group(name, users);
        groups.put(group.getId(), group);
        return group;
    }

    public Expense createExpense(Expense.Builder builder) {
        Expense expense = new Expense(builder);

        User paidBy = expense.getPaidBy();

        for (Split split : expense.getSplits()) {
            User other = split.getUser();

            paidBy.getSheet().adjustBalanceSheet(other, split.getAmount());
            other.getSheet().adjustBalanceSheet(paidBy, -split.getAmount());
        }
        System.out.println("Expense '" + expense.getDescription() + "' of amount " + expense.getAmount() + " created.");
        return expense;
    }

    public void settleUp(String payerId, String payeeId, double amount) {
        User payer = users.get(payerId);
        User payee = users.get(payeeId);
        System.out.println(payer.getName() + " is settling up " + amount + " with " + payee.getName());
        payer.getSheet().adjustBalanceSheet(payee, amount);
        payee.getSheet().adjustBalanceSheet(payer, -amount);
    }

    public List<Transaction> simplifyGroupDebts(String groupId) {
        Group group = groups.get(groupId);

        Map<User, Double> newBalance = new HashMap<>();
        for (User member : group.getUsers()) {
            double balance = 0;
            for (Map.Entry<User, Double> sheet : member.getSheet().getBalances().entrySet()) {
                User user = sheet.getKey();
                if (group.getUsers().contains(user)) {
                    balance += sheet.getValue();
                }
            }
            newBalance.put(member, balance);
        }

        List<Map.Entry<User, Double>> creditors = newBalance.entrySet().stream().filter(entry -> entry.getValue() > 0)
                .collect(Collectors.toList());
        List<Map.Entry<User, Double>> debitors = newBalance.entrySet().stream().filter(entry -> entry.getValue() < 0)
                .collect(Collectors.toList());

        creditors.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        debitors.sort(Map.Entry.comparingByValue());

        List<Transaction> transactions = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < creditors.size() && j < debitors.size()) {
            Map.Entry<User, Double> creditor = creditors.get(i);
            Map.Entry<User, Double> debitor = debitors.get(j);

            double amountToSettle = Math.min(creditor.getValue(), -debitor.getValue());

            transactions.add(new Transaction(debitor.getKey(), creditor.getKey(), amountToSettle));

            creditor.setValue(creditor.getValue() - amountToSettle);
            creditor.setValue(debitor.getValue() + amountToSettle);

            if (creditor.getValue() < 0)
                i++;
            if (debitor.getValue() < 0)
                j++;
        }
        return transactions;
    }

    public void showBalanceSheet(String userId){
        User user = users.get(userId);
        user.getSheet().showBalanceSheet();
    }

}
