package LibraryManagementSystemLLD.factory;

import LibraryManagementSystemLLD.entites.Book;
import LibraryManagementSystemLLD.entites.LibraryItem;
import LibraryManagementSystemLLD.entites.Magazine;
import LibraryManagementSystemLLD.enums.ItemType;

public class ItemFactory {
    public static LibraryItem getInstance(ItemType type, String title, String author){
        switch (type) {
            case BOOK:
                return new Book(title, author); 
            case MAGAZINE:
                return new Magazine(title, author);
            default:
                return null;
        }
    }
}
