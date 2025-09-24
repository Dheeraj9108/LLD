package AuctionSystemLLD.entities;

import java.util.UUID;

import AuctionSystemLLD.observer.Observer;

public class User implements Observer {
    private String id;
    private String name;

    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(String msg) {
        System.out.printf("Message for User %s %s \n", name, msg);
    }
}
