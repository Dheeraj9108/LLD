package PubSubLLD.entites;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;

import PubSubLLD.subscribers.Subscriber;

public class Topic {
    private String name;
    Set<Subscriber> subscribers;
    private ExecutorService deleveryExecutor;

    public Topic(String name,ExecutorService service){
        this.name = name;
        this.deleveryExecutor = service;
        subscribers = new HashSet<>();
    }

    public void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber){
        subscribers.remove(subscriber);
    }

    public void broadCastMessage(Message message){
        deleveryExecutor.submit(()->{
            for(Subscriber subscriber : subscribers){
                subscriber.onMessage(message);
            }
        });
    }

    public String getName() {
        return name;
    }

    public Set<Subscriber> getSubscribers() {
        return subscribers;
    }

    public ExecutorService getDeleveryExecutor() {
        return deleveryExecutor;
    }

}
