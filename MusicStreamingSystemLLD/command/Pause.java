package MusicStreamingSystemLLD.command;

import MusicStreamingSystemLLD.entities.Player;

public class Pause implements Command{
    private Player player;

    public Pause(Player player){
        this.player = player;
    }

    @Override
    public void execute() {
        player.pause();
    }
}
