package TicTacToeLLD.stratergy;

import TicTacToeLLD.entites.Cell;
import TicTacToeLLD.entites.Player;

public class Diagonal implements WinStratergy {

    @Override
    public boolean checkWinner(Cell[][] board, Player player ) {
        boolean winner =  true;
        for(int i = 0;i<board.length;i++){
            if(board[i][i].getSymbol() != player.getSymbol()){
                winner = false;
                break;
            }
        }

        if(winner) return true;

        for(int i = board.length-1;i>=0;i--){
            if(board[board.length-i-1][i].getSymbol() != player.getSymbol()){
                winner = false;
                break;
            }
        }

        return winner;
    }
}
