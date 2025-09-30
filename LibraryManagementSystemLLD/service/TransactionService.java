package LibraryManagementSystemLLD.service;

import java.util.HashMap;
import java.util.Map;

import LibraryManagementSystemLLD.entites.BookCopy;
import LibraryManagementSystemLLD.entites.Loan;
import LibraryManagementSystemLLD.entites.Member;

public class TransactionService {
    private static TransactionService INSTANCE;
    private Map<String,Loan> loans;
    
    private TransactionService(){  
        loans = new HashMap<>();
    }

    public static TransactionService getInstance(){
        if(INSTANCE == null){
            synchronized(TransactionService.class){
                if(INSTANCE == null){
                    INSTANCE = new TransactionService();
                }
            }
        }
        return INSTANCE;
    }

    public void creatLoan(Member member , BookCopy copy){
        if(loans.containsKey(copy.getId())){
            System.out.println("Copy is already in Loan");
        }
        Loan loan = new Loan(member, copy);
        loans.put(copy.getId(), loan);
        member.addLoan(loan);
    }

    public void endLoan(String copyId){
        if(!loans.containsKey(copyId)){
            System.out.println("Record not found");
        }
        Loan loan = loans.remove(copyId);
        loan.getMember().removeLoan(loan);
    }
}
