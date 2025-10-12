package ChessLLD.entities;

import ChessLLD.enums.Color;

public abstract class Piece {

    protected final Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public abstract boolean canMove(Board board, Move move);

    public Color getColor() {
        return color;
    }
}