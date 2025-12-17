package MusicStreamingSystemLLD.stratergy;

import MusicStreamingSystemLLD.entities.Player;
import MusicStreamingSystemLLD.entities.Song;
import MusicStreamingSystemLLD.enums.Subscription;

public interface PlayStratergy {
    
    public void play(Song song, Player player);

    static PlayStratergy getStratergy(Subscription subsriction){
        return subsriction == Subscription.FREE ? new Free() : new Premium();
    }
}
