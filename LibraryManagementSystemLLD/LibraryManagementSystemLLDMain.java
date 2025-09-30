package LibraryManagementSystemLLD;

import java.util.List;

import LibraryManagementSystemLLD.entites.BookCopy;
import LibraryManagementSystemLLD.entites.Member;
import LibraryManagementSystemLLD.enums.ItemType;

public class LibraryManagementSystemLLDMain {
    public static void main(String[] args) {
        // LibraryManagementSystem system = LibraryManagementSystem.getInstance();
        // Member alice = system.creatMember("alice");
        // Member bob = system.creatMember("bob");

        // List<BookCopy> c1 = system.createItem(ItemType.BOOK, "Title1", "Dheeraj", 2);
        
        // system.checkout(bob, c1.get(0));
        // system.checkout(alice, c1.get(0));
        // system.returnItem(c1.get(0));

        LibraryManagementSystem library = LibraryManagementSystem.getInstance();

        // --- Setup: Add items and members using the Facade ---
        System.out.println("=== Setting up the Library ===");

        List<BookCopy> hobbitCopies = library.createItem(ItemType.BOOK,  "The Hobbit", "J.R.R. Tolkien", 2);
        List<BookCopy> duneCopies = library.createItem(ItemType.BOOK,  "Dune", "Frank Herbert", 1);
        // List<BookCopy> natGeoCopies = library.createItem(ItemType.MAGAZINE, "National Geographic", "NatGeo Society", 3);

        Member alice = library.creatMember("Alice");
        Member bob = library.creatMember("Bob");
        Member charlie = library.creatMember("Charlie");

        // --- Scenario 1: Searching (Strategy Pattern) ---
        // System.out.println("\n=== Scenario 1: Searching for Items ===");
        // System.out.println("Searching for title 'Dune':");
        // library.search("Dune", new SearchByTitleStrategy())
        //         .forEach(item -> System.out.println("Found: " + item.getTitle()));
        // System.out.println("\nSearching for author 'Tolkien':");
        // library.search("Tolkien", new SearchByAuthorStrategy())
        //         .forEach(item -> System.out.println("Found: " + item.getTitle()));

        // --- Scenario 2: Checkout and Return (State Pattern) ---
        System.out.println("\n\n=== Scenario 2: Checkout and Return ===");
        library.checkout(alice, hobbitCopies.get(0)); // Alice checks out The Hobbit copy 1
        library.checkout(bob, duneCopies.get(0)); // Bob checks out Dune copy 1

        System.out.println("Attempting to checkout an already checked-out book:");
        library.checkout(charlie, hobbitCopies.get(0)); // Charlie fails to check out The Hobbit copy 1

        System.out.println("\nAlice returns The Hobbit:");
        library.returnItem(hobbitCopies.get(0));

        // --- Scenario 3: Holds and Notifications (Observer Pattern) ---
        System.out.println("\n\n=== Scenario 3: Placing a Hold ===");
        System.out.println("Dune is checked out by Bob. Charlie places a hold.");
        library.placeHold(charlie, duneCopies.get(0).getItem().getId()); // Charlie places a hold on Dune

        System.out.println("\nBob returns Dune. Charlie should be notified.");
        library.returnItem(duneCopies.get(0)); // Bob returns Dune

        System.out.println("\nCharlie checks out the book that was on hold for him.");
        library.checkout(charlie, duneCopies.get(0));

        System.out.println("\nTrying to check out the same on-hold item by another member (Alice):");
        library.checkout(alice, duneCopies.get(0)); // Alice fails, it's checked out by Charlie now.

        // library.printCatalog();
    }
}
