package ChessLLD.entities;

import ChessLLD.enums.Color;

public class King extends Piece{

    public King(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Move move) {
        int rowDiff = Math.abs(move.getFrom().getRow() - move.getTo().getRow());
        int colDiff = Math.abs(move.getFrom().getCol() - move.getTo().getCol());
        return rowDiff <= 1 || colDiff <= 1;
    }
    
}
