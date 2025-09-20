package TicTacToeLLD;

import TicTacToeLLD.entites.Player;
import TicTacToeLLD.entites.Scoreboard;

public class TicTacToeSystem {
    private static TicTacToeSystem INSTANCE;
    private Game game;
    private Scoreboard scoreboard;

    private TicTacToeSystem(){
        scoreboard = new Scoreboard();
    }

    public static TicTacToeSystem getInstance(){
        if(INSTANCE == null){
            synchronized(TicTacToeSystem.class){
                if(INSTANCE == null){
                    INSTANCE = new TicTacToeSystem();
                }
            }
        }
        return INSTANCE;
    }

    public void createGame(Player player1, Player payer2){
        game = new Game(player1, player1);
        this.game.addObserver(scoreboard);
    }

    public void makeMove(Player player, int row, int col){
        System.out.printf("Player %s made move %s %s \n", player.getName(), row, col);
        game.makeMove(player, row, col);
    }

    public void printBoard(){
        game.printBoard();
    }

    public void printScoreboard(){
        scoreboard.printScoreboard();
    }

    public Game getGame() {
        return game;
    }
}
