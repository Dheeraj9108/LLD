package MusicStreamingSystemLLD.command;

import MusicStreamingSystemLLD.entities.Player;

public class Play implements Command{

    private Player player;

    public Play(Player player){
        this.player = player;
    }

    @Override
    public void execute() {
        player.play();
    }
    
}
