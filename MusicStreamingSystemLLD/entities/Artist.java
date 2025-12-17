package MusicStreamingSystemLLD.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import MusicStreamingSystemLLD.observer.Subject;

public class Artist extends Subject {
    private String id;
    private String name;
    private List<Album> albums;
    
    public Artist(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        albums = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void addAlbum(Album album){
        this.albums.add(album);
        notifyObservers(this, album);
    }

}
