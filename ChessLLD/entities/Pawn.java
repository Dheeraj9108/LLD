package ChessLLD.entities;

import ChessLLD.enums.Color;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Move move) {
        int rowDiff = move.getFrom().getRow() - move.getTo().getRow();
        int colDiff = Math.abs(move.getFrom().getCol() - move.getTo().getCol());

        if (color == Color.WHITE) {
            return (rowDiff == 1 && colDiff == 0) ||
                    (move.getFrom().getRow() == 1 && rowDiff == 2 && colDiff == 0) ||
                    (rowDiff == 1 && colDiff == 1
                            && board.getPiece(move.getTo().getRow(), move.getTo().getCol()) != null);
        } else {
            return (rowDiff == -1 && colDiff == 0) ||
                    (move.getFrom().getRow() == 1 && rowDiff == -2 && colDiff == 0) ||
                    (rowDiff == -1 && colDiff == 1
                            && board.getPiece(move.getTo().getRow(), move.getTo().getCol()) != null);
        }
    }

}
