package TicTacToeLLD.entites;

import TicTacToeLLD.enums.Symbol;

public class Board {

    int size;
    int moveCount;
    private Cell board[][];

    public Board(int size){
        this.size = size;
        board = new Cell[size][size];
        moveCount = 0;
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                board[i][j] = new Cell(Symbol.EMPTY);
            }
        }
    }

    public void makeMove(Player player, int row, int col){
        if(board[row][col].getSymbol() != Symbol.EMPTY){
            System.out.println("Invalid Move");
        }
        board[row][col].setSymbol(player.getSymbol());
        moveCount++;
    }


    public void print(){
        System.out.println("---Board---");
        for(int i = 0;i<size;i++){
            for(int j =0;j<size;j++){
                System.out.print(board[i][j].getSymbol().getChar()+" ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }

    public boolean isFull(){
        return moveCount == size * size;
    }

    public int getSize() {
        return size;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public Cell[][] getBoard() {
        return board;
    }
}
