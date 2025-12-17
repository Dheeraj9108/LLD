package MusicStreamingSystemLLD.entities;

import java.util.UUID;

public class Song {
    private String id;    
    private String name;
    private String artist;
    private int duration;

    public Song(String name, String artist, int duration) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.artist = artist;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }
    
}
