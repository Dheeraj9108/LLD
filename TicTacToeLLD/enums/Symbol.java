package TicTacToeLLD.enums;

public enum Symbol {
    X('X'),
    O('O'),
    EMPTY('-');

    private char ch;
    
    Symbol(char ch){
        this.ch = ch;
    }

    public char getChar() {
        return ch;
    }
}
