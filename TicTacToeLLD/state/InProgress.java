package TicTacToeLLD.state;

import TicTacToeLLD.Game;
import TicTacToeLLD.entites.Player;
import TicTacToeLLD.enums.GameStatus;
import TicTacToeLLD.enums.Symbol;

public class InProgress implements GameState {

    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        game.getBoard().makeMove(player, row, col);
        if (game.checkWinner()) {
            game.setState(new Winner());
            game.setStatus(player.getSymbol() == Symbol.X ? GameStatus.WINNER_X : GameStatus.WINNER_O);
        } else if(game.isFull()){
            game.setState(new Draw());
            game.setStatus(GameStatus.DRAW);
        } else {
            game.switchPlayer();
        }
    }
}
