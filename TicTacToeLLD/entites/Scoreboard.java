package TicTacToeLLD.entites;

import java.util.HashMap;
import java.util.Map;

import TicTacToeLLD.observer.GameObserver;

public class Scoreboard implements GameObserver{

    Map<String,Integer> scores = new HashMap<>();
    
    @Override
    public void update(Player player) {
        scores.put(player.getName(),scores.getOrDefault(player.getName(), 0)+1);
    }
    
    public void printScoreboard(){
        System.out.println("-------Scoreboard------");
        for(Map.Entry<String,Integer> set:scores.entrySet()){
            System.out.printf("Player %s won %s times \n",set.getKey(),set.getValue());
        }
        System.out.println("-----------------------");
    }
}
