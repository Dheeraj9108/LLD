package ChessLLD.entities;

import ChessLLD.enums.Color;

public class Rook extends Piece{

    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Move move) {
        return (move.getFrom().getRow() == move.getTo().getRow()) || (move.getFrom().getCol() == move.getTo().getCol());
    }
    
}
