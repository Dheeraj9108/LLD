package entites;

import java.util.UUID;

public class User {
    String id;
    String name;
    int reputation;
    public User(String name){
        id = UUID.randomUUID().toString();
        this.name = name;
        reputation = 0;
    }

    public void setReputaion(int rep){
        this.reputation+=rep;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReputation() {
        return reputation;
    }
}
