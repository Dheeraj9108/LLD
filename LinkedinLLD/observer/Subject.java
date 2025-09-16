package LinkedinLLD.observer;

import java.util.ArrayList;
import java.util.List;

import LinkedinLLD.entites.Notification;

public abstract class Subject {
    protected List<NotificationObserver> observers;

    public Subject(){
        this.observers = new ArrayList<>();
    }

    public void addObserver(NotificationObserver observer){
        this.observers.add(observer);
    }

    protected void notifyObserver(Notification notification){
        for(NotificationObserver observer: observers){
            observer.update(notification);
        }
    }
}
