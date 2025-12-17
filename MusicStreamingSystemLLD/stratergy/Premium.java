package MusicStreamingSystemLLD.stratergy;

import MusicStreamingSystemLLD.entities.Player;
import MusicStreamingSystemLLD.entities.Song;

public class Premium implements PlayStratergy{

    @Override
    public void play(Song song, Player player) {
        player.setCurSong(song);
                System.out.printf("Premium user %s is playing %s\n", player.getCurUser().getName(),song.getName());

    }
    
}
