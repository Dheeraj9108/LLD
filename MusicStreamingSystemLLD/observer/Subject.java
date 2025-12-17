package MusicStreamingSystemLLD.observer;

import java.util.ArrayList;
import java.util.List;

import MusicStreamingSystemLLD.entities.Album;
import MusicStreamingSystemLLD.entities.Artist;

public abstract class Subject {
    private List<ArtistObserver> observers;

    public Subject(){
        observers = new ArrayList<>();
    }

    public void addObserver(ArtistObserver observer){
        this.observers.add(observer);
    }

    public void notifyObservers(Artist artist, Album album){
        for(ArtistObserver observer : observers){
            observer.update(artist, album);
        }
    }
}
