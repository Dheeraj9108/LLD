package TicTacToeLLD.state;

import TicTacToeLLD.Game;
import TicTacToeLLD.entites.Player;

public interface GameState {
    public void handleMove(Game game, Player player, int row, int col);
}
