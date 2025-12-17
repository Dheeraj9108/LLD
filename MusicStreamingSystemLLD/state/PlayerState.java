package MusicStreamingSystemLLD.state;

import MusicStreamingSystemLLD.entities.Player;

public interface PlayerState {
    
    void play(Player player);
    void pause(Player player);
    void stop(Player player);
     
}
