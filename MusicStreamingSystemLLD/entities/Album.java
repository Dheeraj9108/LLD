package MusicStreamingSystemLLD.entities;

import java.util.ArrayList;
import java.util.List;

public class Album implements Playable{
    private String name;
    private List<Song> songs;

    public Album(String name){
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public List<Song> getTracks() {
        return songs;
    }

    public void addTrack(Song song){
        this.songs.add(song);
    }
}
