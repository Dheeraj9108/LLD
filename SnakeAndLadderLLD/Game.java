package SnakeAndLadderLLD;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import SnakeAndLadderLLD.entity.Board;
import SnakeAndLadderLLD.entity.BoardEntity;
import SnakeAndLadderLLD.entity.Dice;
import SnakeAndLadderLLD.entity.Player;
import SnakeAndLadderLLD.enums.GameStatus;

public class Game {
    private Board board;
    private Queue<Player> players;
    private Dice dice;
    private GameStatus status;

    public Game(GameBuilder builder) {
        this.status = GameStatus.NOT_STARTED;
        this.players = new LinkedList<>(builder.players);
        this.dice = builder.dice;
        this.board = builder.board;
    }

    public void play(){
        this.status = GameStatus.RUNNING;
        
        while (status == GameStatus.RUNNING) {
            Player cur = players.poll();
            takeTurn(cur);

            if(status == GameStatus.RUNNING){
                players.add(cur);
            }
        }
    }

    private void takeTurn(Player player){
        System.out.printf("%s turn \n",player.getName());
        int roll = dice.roll();
        int curPos = player.getPosition();
        int nextPos = curPos+roll;
        
        if(nextPos > board.getSize()){
            System.out.printf("%s should land exactly on %s \n",player.getName(),board.getSize());
            return;
        }
        
        if(nextPos == board.getSize()){
            this.status = GameStatus.FINISHED;
            System.out.printf("%s won \n",player.getName());
            return;
        }
        
        int finalPos = board.getFinalPosition(nextPos);
        
        if(finalPos > nextPos){
            System.out.printf("%s got ladder \n",player.getName());
        } else if(finalPos < nextPos){
            System.out.printf("%s got snake \n",player.getName());
        }
        
        player.setPosition(finalPos);
        
        if(roll == dice.getMaxValue()){
            System.out.printf("%s got another chance \n",player.getName());
            takeTurn(player);
        }

    }

    public static class GameBuilder {
        private Board board;
        private List<Player> players = new ArrayList<>();
        private Dice dice;

        public GameBuilder() {

        }

        public GameBuilder setBoard(int size, List<BoardEntity> entites) {
            this.board = new Board(size, entites);
            return this;
        }

        public GameBuilder setPlayers(List<String> players) {
            for(String player : players){
                this.players.add(new Player(player));
            }
            return this;
        }

        public GameBuilder setDice(Dice dice) {
            this.dice = dice;
            return this;
        }

        public Game build() {
            return new Game(this);
        }

    }
}
