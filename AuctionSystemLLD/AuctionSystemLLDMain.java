package AuctionSystemLLD;

import java.time.LocalDateTime;
import java.util.List;

import AuctionSystemLLD.entities.Auction;
import AuctionSystemLLD.entities.User;

public class AuctionSystemLLDMain {
    public static void main(String[] args) throws InterruptedException {
        AuctionSystem system  = AuctionSystem.getInstance();

        User Alice = system.createUser("alice");
        User Bob = system.createUser("Bob");
        
        Auction auction1 = system.createAuction("ABC", "Description", 20, LocalDateTime.now().plusSeconds(10));
        // Auction auction2 = system.createAuction("ABD", "Description", 20, LocalDateTime.now().plusSeconds(10));

        List<Auction> auctions = system.viewActiveAuctions();
        for(Auction auction : auctions){
            System.out.printf("Item Name: %s\n",auction.getItemName());
        }

        system.placeBid(auction1.getId(), Alice, 30);
        Thread.sleep(500);
        system.placeBid(auction1.getId(), Bob, 40);
        Thread.sleep(500);
        system.placeBid(auction1.getId(), Alice, 40);
        Thread.sleep(500);
        system.placeBid(auction1.getId(), Alice, 50);
        Thread.sleep(2*1000);
        system.shutdown();
    }
}
