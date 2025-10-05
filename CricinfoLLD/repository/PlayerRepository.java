package CricinfoLLD.repository;

import java.util.HashMap;
import java.util.Map;

import CricinfoLLD.entities.Player;

public class PlayerRepository {
    private Map<String,Player> players;
    
    public PlayerRepository(){
        players = new HashMap<>();
    }
    
    public void save(Player player){
        players.put(player.getId(),player);
    }
}
