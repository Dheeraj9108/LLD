package MusicStreamingSystemLLD.command;

import MusicStreamingSystemLLD.entities.Player;

public class Next implements Command{
    
    private Player player;

    public Next(Player player){
        this.player = player;
    }

    @Override
    public void execute() {
        player.next();
    }
}
