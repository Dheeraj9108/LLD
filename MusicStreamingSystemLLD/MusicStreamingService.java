package MusicStreamingSystemLLD;

import java.util.HashMap;
import java.util.Map;

import MusicStreamingSystemLLD.entities.Artist;
import MusicStreamingSystemLLD.entities.Player;
import MusicStreamingSystemLLD.entities.Song;
import MusicStreamingSystemLLD.entities.User;

public class MusicStreamingService {

    private static MusicStreamingService INSTANCE;
    private Map<String,User> users ; 
    private Map<String,Song> songs ; 
    private Map<String,Artist> artists ; 

    private MusicStreamingService(){
        this.users = new HashMap<>();
        this.songs = new HashMap<>();
        this.artists = new HashMap<>();
    }

    public static MusicStreamingService getInstance(){
        if(INSTANCE == null){
            synchronized(MusicStreamingService.class){
                if(INSTANCE == null){
                    INSTANCE = new MusicStreamingService();
                }
            }
        }
        return INSTANCE;
    }
    
    public void registerUser(User user){
        users.put(user.getId(), user);
    }

    public void addArtist(Artist artist){
        artists.put(artist.getId(), artist);
    }

    public Song addSong(String name, String artist, int duration){
        Song song = new Song(name, artist, duration);
        songs.put(song.getId(), song);
        return song;
    }

    public Player getPlayer(){
        return new Player();
    }
}
