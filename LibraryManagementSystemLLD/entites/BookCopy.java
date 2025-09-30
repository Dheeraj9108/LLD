package LibraryManagementSystemLLD.entites;

import java.util.UUID;

import LibraryManagementSystemLLD.state.Available;
import LibraryManagementSystemLLD.state.ItemState;

public class BookCopy {
    private String id;
    private LibraryItem item;
    private ItemState state;

    public BookCopy(LibraryItem item) {
        this.id = UUID.randomUUID().toString();
        this.item = item;
        item.addCopy(this);
        state = new Available();
    }

    public void checkout(Member member) {
        state.checkout(this, member);
    }

    public void returnItem() {
        state.returnItem(this);
    }

    public void placeHold(Member member) {
        state.placeHold(this, member);
    }

    public void setState(ItemState state){
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public LibraryItem getItem() {
        return item;
    }

    public ItemState getState() {
        return state;
    }

    public boolean isAvailable(){
        return state instanceof Available;
    }
}
