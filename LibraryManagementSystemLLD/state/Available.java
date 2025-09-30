package LibraryManagementSystemLLD.state;

import LibraryManagementSystemLLD.entites.BookCopy;
import LibraryManagementSystemLLD.entites.Member;
import LibraryManagementSystemLLD.service.TransactionService;

public class Available implements ItemState{

    @Override
    public void checkout(BookCopy copy, Member member) {
        TransactionService.getInstance().creatLoan(member, copy);
        System.out.println("Checkout Success");
        copy.setState(new Checkedout());
    }

    @Override
    public void returnItem(BookCopy copy) {
    }

    @Override
    public void placeHold(BookCopy copy, Member member) {
    }
    
}
