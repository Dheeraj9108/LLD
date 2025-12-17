package MusicStreamingSystemLLD.state;

import MusicStreamingSystemLLD.entities.Player;
import MusicStreamingSystemLLD.enums.PlayerStatus;

public class Stopped implements PlayerState{

    @Override
    public void play(Player player) {
        if(!player.isQueueEmpty()){
            System.out.println("Playing song.");
            player.setState(new Playing());
            player.setStatus(PlayerStatus.PLAYING);
            player.playSongInQueue();
        } else {
            System.out.println("No Songs to play");
        }
    }

    @Override
    public void pause(Player player) {
    }

    @Override
    public void stop(Player player) {
    }
    
}
