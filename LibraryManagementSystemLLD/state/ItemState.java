package LibraryManagementSystemLLD.state;

import LibraryManagementSystemLLD.entites.BookCopy;
import LibraryManagementSystemLLD.entites.Member;

public interface ItemState {
    public void checkout(BookCopy copy,Member member);
    public void returnItem(BookCopy copy);
    public void placeHold(BookCopy copy, Member member);
}
