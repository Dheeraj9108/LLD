package LibraryManagementSystemLLD.entites;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import LibraryManagementSystemLLD.observer.Observer;

public abstract class LibraryItem {
    private String id;
    private String title;
    private List<Observer> observers ;
    private List<BookCopy> copies;

    public LibraryItem(String title){
        this.id = UUID.randomUUID().toString();
        this.title = title;
        observers = new ArrayList<>();
        copies = new ArrayList<>();
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public boolean isMember(Observer observer){
        return observers.contains(observer);
    }

    public void notifyObserver(){
        for(Observer observer: observers){
            observer.update(this);
        }
    }

    public void addCopy(BookCopy copy){
        copies.add(copy);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public boolean hasObservers(){
        return !observers.isEmpty();
    }

    public List<BookCopy> getCopies() {
        return copies;
    }

    public abstract String getAuthorPublisher();
}
