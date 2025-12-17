package MusicStreamingSystemLLD.state;

import MusicStreamingSystemLLD.entities.Player;
import MusicStreamingSystemLLD.enums.PlayerStatus;

public class Paused implements PlayerState{

    @Override
    public void play(Player player) {
        System.out.println("Songs is playing");
        player.setState(new Playing());
        player.setStatus(PlayerStatus.PLAYING);
    }
    
    @Override
    public void pause(Player player) {
    }
    
    @Override
    public void stop(Player player) {
        System.out.println("Songs is stopped");
        player.setState(new Stopped());
        player.setStatus(PlayerStatus.STOPPED);
    }
    
}
