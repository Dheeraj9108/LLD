package ChessLLD.entities;

import ChessLLD.enums.Color;

public class Board {
    private Cell[][] board;

    public Board() {
        board = new Cell[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Cell(i, j);
            }
        }

        for (int i = 0; i < 8; i++) {
            board[1][i].setPiece(new Pawn(Color.BLACK));
            board[6][i].setPiece(new Pawn(Color.WHITE));
        }

        board[0][0].setPiece(new Rook(Color.BLACK));
        board[0][1].setPiece(new Bishop(Color.BLACK));
        board[0][2].setPiece(new Knight(Color.BLACK));
        board[0][3].setPiece(new Queen(Color.BLACK));
        board[0][4].setPiece(new King(Color.BLACK));
        board[0][5].setPiece(new Knight(Color.BLACK));
        board[0][6].setPiece(new Bishop(Color.BLACK));
        board[0][7].setPiece(new Rook(Color.BLACK));

        board[7][0].setPiece(new Rook(Color.WHITE));
        board[7][1].setPiece(new Bishop(Color.WHITE));
        board[7][2].setPiece(new Knight(Color.WHITE));
        board[7][3].setPiece(new Queen(Color.WHITE));
        board[7][4].setPiece(new King(Color.WHITE));
        board[7][5].setPiece(new Knight(Color.WHITE));
        board[7][6].setPiece(new Bishop(Color.WHITE));
        board[7][7].setPiece(new Rook(Color.WHITE));
    }

    public boolean isCheckmate(Color color) {
        return false;
    }

    public boolean isStalemate(Color color) {
        return false;
    }

    public Piece getPiece(int row, int col) {
        return board[row][col].getPiece();
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    public void movePiece(Move move) {
        Cell from = move.getFrom();
        Cell to = move.getTo();
        Piece piece = from.getPiece();
        if (piece == null || !piece.canMove(this, move)) {
            System.out.println("Invalid move");
        }

        to.setPiece(piece);
        from.setPiece(null);
    }
}
