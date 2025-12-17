package MusicStreamingSystemLLD.state;

import MusicStreamingSystemLLD.entities.Player;
import MusicStreamingSystemLLD.enums.PlayerStatus;

public class Playing implements PlayerState{

    @Override
    public void play(Player player) {
    }

    @Override
    public void pause(Player player) {
        System.out.println("Song paused");
        player.setStatus(PlayerStatus.PAUSED);
        player.setState(new Paused());
    }
    
    @Override
    public void stop(Player player) {
        System.out.println("Song stopped");
        player.setStatus(PlayerStatus.STOPPED);
        player.setState(new Stopped());
    }
    
}
