package LibraryManagementSystemLLD.entites;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import LibraryManagementSystemLLD.observer.Observer;

public class Member implements Observer{
    private String id;
    private String name;
    private List<Loan> loans;
    
    public Member(String name){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        loans = new ArrayList<>(); 
    }

    @Override
    public void update(LibraryItem item) {
        System.out.printf("[Notification] Item %s is available now\n", item.getTitle());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addLoan(Loan loan){
        loans.add(loan);
    }

    public void removeLoan(Loan loan){
        loans.remove(loan);
    }

}
