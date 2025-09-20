package TicTacToeLLD;

import TicTacToeLLD.entites.Player;
import TicTacToeLLD.enums.Symbol;

public class TicTacToeLLDMain {
    public static void main(String[] args) {
        TicTacToeSystem system = TicTacToeSystem.getInstance();

        Player alice = new Player("Alice", Symbol.X);
        Player bob = new Player("Bob", Symbol.O);

        system.createGame(alice, bob);

        system.makeMove(alice, 0, 0);
        system.makeMove(bob, 0, 2);
        system.makeMove(alice, 1, 0);
        system.makeMove(bob, 1, 2);
        system.printBoard();
        system.makeMove(alice, 2, 0);
        system.printScoreboard();
    }    
}
