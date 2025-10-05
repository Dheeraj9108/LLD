package CricinfoLLD.entities;

import java.util.List;
import java.util.UUID;

public class Team {
    private String id;
    private String name;
    private List<Player> players;
    
    public Team(String name, List<Player> players) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.players = players;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

}
