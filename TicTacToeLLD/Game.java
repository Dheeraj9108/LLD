package TicTacToeLLD;

import java.util.Arrays;
import java.util.List;

import TicTacToeLLD.entites.Board;
import TicTacToeLLD.entites.Player;
import TicTacToeLLD.enums.GameStatus;
import TicTacToeLLD.observer.GameSubject;
import TicTacToeLLD.state.GameState;
import TicTacToeLLD.state.InProgress;
import TicTacToeLLD.stratergy.Column;
import TicTacToeLLD.stratergy.Diagonal;
import TicTacToeLLD.stratergy.Row;
import TicTacToeLLD.stratergy.WinStratergy;

public class Game extends GameSubject{

    private Board board;
    private Player player1;
    private Player player2;
    private Player winner;
    private Player curPlayer;
    private GameState state;
    private GameStatus status;
    private List<WinStratergy> winStratergy;

    public Game(Player player1, Player player2) {
        this.board = new Board(3);
        this.player1 = player1;
        this.player2 = player2;
        this.state = new InProgress();
        this.status = GameStatus.INPROGRESS;
        this.curPlayer = player1;
        this.winStratergy = Arrays.asList(new Row(), new Column(), new Diagonal());
    }

    public void makeMove(Player player, int row, int col) {
        state.handleMove(this, player, row, col);
    }

    public boolean checkWinner() {
        for (WinStratergy strategry : winStratergy) {
            if (strategry.checkWinner(board.getBoard(), curPlayer))
                return true;
        }
        return false;
    }

    public void switchPlayer(){
        this.curPlayer = curPlayer.getName().equals(player1.getName()) ? player2 : player1;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void setStatus(GameStatus status){
        this.status = status;
        if(status != GameStatus.INPROGRESS && status != GameStatus.DRAW){
            notifyObservers(curPlayer);
        }
    }

    public void printBoard(){
        board.print();
    }

    public boolean isFull(){
        return board.isFull();
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getCurPlayer() {
        return curPlayer;
    }

    public GameState getState() {
        return state;
    }

    public List<WinStratergy> getWinStratergy() {
        return winStratergy;
    }

    public GameStatus getStatus() {
        return status;
    }
}
