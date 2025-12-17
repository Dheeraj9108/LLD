package MusicStreamingSystemLLD.stratergy;

import MusicStreamingSystemLLD.entities.Player;
import MusicStreamingSystemLLD.entities.Song;

public class Free implements PlayStratergy {

    private int ADD_AFTER = 3;
    private int songsPlayed = 0;

    @Override
    public void play(Song song, Player player) {
        if(songsPlayed > 0 && songsPlayed % ADD_AFTER == 0){
            System.out.println("Subscribe to Premium for ADD free Music");
        }
        songsPlayed++;
        player.setCurSong(song);
        System.out.printf("Free user %s is playing %s \n", player.getCurUser().getName(),song.getName());
    }
    
}
