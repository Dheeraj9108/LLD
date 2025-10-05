package CricinfoLLD.entities;

import java.util.UUID;

import CricinfoLLD.enums.PlayerType;

public class Player {
    private String id;
    private String name;
    private PlayerType type;
    private PlayerStat stat;
    
    public Player(String name, PlayerType type) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.type = type;
        this.stat = new PlayerStat();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PlayerType getType() {
        return type;
    }

    public PlayerStat getStat() {
        return stat;
    }

}
