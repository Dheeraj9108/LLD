package TicTacToeLLD.stratergy;

import TicTacToeLLD.entites.Cell;
import TicTacToeLLD.entites.Player;

public interface WinStratergy {
    public boolean checkWinner(Cell[][] board, Player player);
}
