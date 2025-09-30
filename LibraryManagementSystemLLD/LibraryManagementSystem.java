package LibraryManagementSystemLLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LibraryManagementSystemLLD.entites.BookCopy;
import LibraryManagementSystemLLD.entites.LibraryItem;
import LibraryManagementSystemLLD.entites.Member;
import LibraryManagementSystemLLD.enums.ItemType;
import LibraryManagementSystemLLD.factory.ItemFactory;
import LibraryManagementSystemLLD.stratergy.Search;

public class LibraryManagementSystem {
    private static LibraryManagementSystem INSTANCE;
    private Map<String, BookCopy> copies;
    private Map<String,LibraryItem> catalog;
    private Map<String, Member> members;
    
    private LibraryManagementSystem(){
        this.copies = new HashMap<>();
        this.catalog = new HashMap<>();
        this.members = new HashMap<>();
    }

    public static LibraryManagementSystem getInstance(){
        if(INSTANCE == null){
            synchronized(LibraryManagementSystem.class){
                if(INSTANCE == null){
                    INSTANCE = new LibraryManagementSystem();
                }
            }
        }
        return INSTANCE;
    }

    public Member creatMember(String name){
        Member member = new Member(name);
        members.put(member.getId(), member);
        return member;
    }

    public List<BookCopy> createItem(ItemType type, String title, String author, int noOfCopies){
        LibraryItem item = ItemFactory.getInstance(type, title, author);
        catalog.put(item.getId(), item);
        List<BookCopy> itemList = new ArrayList<>();

        for(int i = 0;i<noOfCopies;i++){
            BookCopy copy = new BookCopy(item);
            copies.put(copy.getId(), copy);
            itemList.add(copy);
        }
        return itemList;
    }

    public void checkout(Member member, BookCopy copy){
        copy.checkout(member);
    }

    public void returnItem(BookCopy copy){
        copy.returnItem();
    }

    public void placeHold(Member member,String itemId){
        System.out.println(itemId);
        LibraryItem item = catalog.get(itemId);
        if(item != null){
            item.getCopies().stream().filter(copy -> !copy.isAvailable()).findFirst().ifPresent(c->c.placeHold(member));
        }
    }

    public List<LibraryItem> search(Search stratergy, String key){
        return stratergy.search(new ArrayList<>(catalog.values()), key);
    }
}
