package ChessLLD;

import java.util.Scanner;

import ChessLLD.entities.Board;
import ChessLLD.entities.Move;
import ChessLLD.entities.Piece;
import ChessLLD.entities.Player;
import ChessLLD.enums.Color;

public class ChessGame {
    private Board board;
    private Player black;
    private Player white;
    private Player curr;

    public ChessGame(String player1, String player2){
        this.board = new Board();
        this.white = new Player(player1, Color.WHITE);
        this.black = new Player(player2, Color.BLACK);

        this.curr = white;
    }

    public void start(){
        while(!isGameOver()){
            System.out.printf("player %s turn \n", curr.getName());
            Move move = getMove();
            if(move == null) continue;
            board.movePiece(move);
            switchPlayer();
        }
        displayResult();
    }

    private void switchPlayer(){
        curr = curr == black ? white : black;
    }

    private Move getMove(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Source Row");
        int srcRow = scanner.nextInt();
        System.out.println("Source Col");
        int srcCol = scanner.nextInt();
        System.out.println("Dest Row");
        int destRow = scanner.nextInt();
        System.out.println("Dest Col");
        int destCol = scanner.nextInt();

        Piece piece = board.getPiece(srcRow,srcCol);
        
        scanner.close();
        if(piece == null || piece.getColor() != curr.getColor()){
            System.out.println("Invalid move");
            return null;
        }

        return new Move(board.getCell(srcRow,srcCol), board.getCell(destRow,destCol));
    }

    private boolean isGameOver(){
        return (board.isCheckmate(curr.getColor()) || board.isStalemate(curr.getColor()));
    }

    public void displayResult(){

    }

}
