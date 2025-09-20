package TicTacToeLLD.stratergy;

import TicTacToeLLD.entites.Cell;
import TicTacToeLLD.entites.Player;

public class Column implements WinStratergy{

    @Override
    public boolean checkWinner(Cell[][] board, Player player ) {
        
        for(int j = 0;j<board.length;j++){
            boolean winner = true;
            for(int i = 0;i<board.length;i++){
                if(board[i][j].getSymbol() != player.getSymbol()){
                    winner = false;
                    break;
                }
            }
            if(winner) return true;
        }
        return false;
    }
    
}
