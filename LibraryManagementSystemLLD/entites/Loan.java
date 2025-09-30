package LibraryManagementSystemLLD.entites;

import java.time.LocalDate;

public class Loan {
    private Member member;
    private LocalDate checkoutDate;
    private BookCopy copy;

    public Loan(Member member, BookCopy copy){
        this.copy = copy;
        this.member = member;
        this.checkoutDate = LocalDate.now(); 
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public BookCopy getCopy() {
        return copy;
    }

}
