package LibraryManagementSystemLLD.state;

import LibraryManagementSystemLLD.entites.BookCopy;
import LibraryManagementSystemLLD.entites.Member;
import LibraryManagementSystemLLD.service.TransactionService;

public class Checkedout implements ItemState{

    @Override
    public void checkout(BookCopy copy, Member member) {
        System.out.println("Already Checked Out");
    }

    @Override
    public void returnItem(BookCopy copy) {
        TransactionService.getInstance().endLoan(copy.getId());

        if(copy.getItem().hasObservers()){  
            copy.setState(new PlaceHold());
            copy.getItem().notifyObserver();
        } else {
            copy.setState(new Available());
        }
        System.out.println("Item Returned");
    }

    @Override
    public void placeHold(BookCopy copy, Member member) {
        copy.getItem().addObserver(member);
    }
    
}
