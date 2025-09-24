package AuctionSystemLLD.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import AuctionSystemLLD.enums.Status;
import AuctionSystemLLD.observer.Observer;

public class Auction {
    private String id;
    private String itemName;
    private String description;
    private LocalDateTime endTime;
    private int startPrice;
    private List<Bid> bids;
    private Set<Observer> observers;
    private Status status;
    private Bid winner;

    public Auction(String itemName, String description, LocalDateTime endTime, int startPrice) {
        this.id = UUID.randomUUID().toString();
        this.itemName = itemName;
        this.description = description;
        this.endTime = endTime;
        this.startPrice = startPrice;
        this.bids = new ArrayList<>();
        this.observers = new HashSet<>();
        this.status = Status.ACTIVE;
    }

    public void placeBid(Bid bid){
        if(status != Status.ACTIVE){
            return;
        }

        if(endTime.isBefore(bid.getTimeStamp())) return;

        Bid max = getHighestBid();
        if(max != null){
            if(bid.getAmount() < startPrice || bid.getAmount() <= max.getAmount()){
                System.out.println("Amount should be greater than the max bid");
                return;
            }
            String msg = String.format("You have been out bid with heighest bid of %s", bid.getAmount());
            notifyObersever(max.getBidder(),msg);
        }
        addOberver(bid.getBidder());
        bids.add(bid);

    }

    public void endAuction(){
        if(status != Status.ACTIVE){
            return ;
        }

        status = Status.CLOSED;
        winner = getHighestBid();
        if(winner  == null){
            System.out.println("No Winner");
            return;
        }
        String msg = String.format("Winner %s won the bid with %s", winner.getBidder().getName(), winner.getAmount());
        notifyAllObersever(msg);
    }

    public boolean isActive(){
        return status == Status.ACTIVE;
    }

    public void addOberver(Observer observer){
        observers.add(observer);
    }

    public void notifyObersever(Observer observer, String msg){
        observer.update(msg);
    }

    public void notifyAllObersever(String msg){
        for(Observer observer: observers){
            observer.update(msg);
        }
    }

    public Bid getHighestBid(){
        if(bids.isEmpty()) return null;
        return Collections.max(bids);
    }

    public String getId() {
        return id;
    }
    public String getItemName() {
        return itemName;
    }
    public String getDescription() {
        return description;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public int getStartPrice() {
        return startPrice;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public Set<Observer> getObservers() {
        return observers;
    }

    public Status getStatus() {
        return status;
    }

}
