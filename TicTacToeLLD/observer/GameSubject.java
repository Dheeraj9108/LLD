package TicTacToeLLD.observer;

import java.util.ArrayList;
import java.util.List;

import TicTacToeLLD.entites.Player;

public abstract class GameSubject {
    List<GameObserver> observers = new ArrayList<>();

    public void addObserver(GameObserver observer){
        observers.add(observer);
    }

    public void notifyObservers(Player player){
        for(GameObserver observer : observers){
            observer.update(player);
        }
    }
}
