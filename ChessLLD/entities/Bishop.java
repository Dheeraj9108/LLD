package ChessLLD.entities;

import ChessLLD.enums.Color;

public class Bishop extends Piece{

    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Move move) {
        int rowDiff = Math.abs(move.getFrom().getRow() - move.getTo().getRow());
        int colDiff = Math.abs(move.getFrom().getCol() - move.getTo().getCol());
        return rowDiff == colDiff;
    }
    
}
