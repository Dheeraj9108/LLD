package AuctionSystemLLD.entities;

import java.time.LocalDateTime;

public class Bid implements Comparable<Bid>{
    private User bidder;
    private LocalDateTime timeStamp;
    private Integer amount;
    
    public Bid(User bidder, int amount) {
        this.bidder = bidder;
        this.timeStamp = LocalDateTime.now();
        this.amount = amount;
    }

    public User getBidder() {
        return bidder;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public int compareTo(Bid other) {
        int max = this.amount.compareTo(other.getAmount());
        if(max != 0){
            return max;
        }

        return other.getTimeStamp().compareTo(timeStamp);
    }
}
