package ChessLLD.entities;

import ChessLLD.enums.Color;

public class Queen extends Piece {

    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Move move) {
        int rowDiff = Math.abs(move.getFrom().getRow() - move.getTo().getRow());
        int colDiff = Math.abs(move.getFrom().getCol() - move.getTo().getCol());
        return (rowDiff == colDiff) || (move.getFrom().getRow() == move.getTo().getRow()) || (move.getFrom().getCol() == move.getTo().getCol());
    }
    
}
