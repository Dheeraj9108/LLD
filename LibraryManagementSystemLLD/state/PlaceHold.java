package LibraryManagementSystemLLD.state;

import LibraryManagementSystemLLD.entites.BookCopy;
import LibraryManagementSystemLLD.entites.Member;
import LibraryManagementSystemLLD.service.TransactionService;

public class PlaceHold implements ItemState{

    @Override
    public void checkout(BookCopy copy, Member member) {
        if(copy.getItem().isMember(member)){
            TransactionService.getInstance().creatLoan(member, copy);
            copy.getItem().removeObserver(member);
            copy.setState(new Checkedout());
        }
    }

    @Override
    public void returnItem(BookCopy copy) {
    }

    @Override
    public void placeHold(BookCopy copy, Member member) {
        copy.getItem().addObserver(member);
    }
    
}
