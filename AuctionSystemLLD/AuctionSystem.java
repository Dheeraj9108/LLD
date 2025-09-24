package AuctionSystemLLD;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import AuctionSystemLLD.entities.Auction;
import AuctionSystemLLD.entities.Bid;
import AuctionSystemLLD.entities.User;

public class AuctionSystem {

    private static AuctionSystem INSTANCE;
    private Map<String, User> users; 
    private Map<String, Auction> auctions;
    private ScheduledExecutorService service;

    private AuctionSystem(){
        this.users = new HashMap<>();
        this.auctions = new HashMap<>();
        this.service = Executors.newScheduledThreadPool(1);
    }

    public User createUser(String name){
        User user = new User(name);
        users.put(user.getId(), user);
        return user;
    }

    public Auction createAuction(String itemName, String description, int startPrice, LocalDateTime endTime){
        Auction auction = new Auction(itemName, description, endTime, startPrice);
        auctions.put(auction.getId(), auction);
        long delay = java.time.Duration.between(LocalDateTime.now(), endTime).toMillis();
        service.schedule(()->endAuction(auction.getId()), delay, TimeUnit.MILLISECONDS);
        return auction;
    }

    public void placeBid(String auctionId, User bidder, int amout){
        Auction auction = auctions.get(auctionId);
        Bid bid = new Bid(bidder, amout);
        auction.placeBid(bid);
    }

    private void endAuction(String auctionId){
        Auction auction = auctions.get(auctionId);
        auction.endAuction();
    }

    public static AuctionSystem getInstance(){
        if(INSTANCE == null){
            synchronized(AuctionSystem.class){
                if(INSTANCE == null){
                    INSTANCE = new AuctionSystem();
                }
            }
        }
        return INSTANCE;
    }

    public List<Auction> viewActiveAuctions(){
        return auctions.values().stream().filter(auction->auction.isActive()).collect(Collectors.toList());
    }

    public void shutdown(){
        service.shutdown();
    }
}
