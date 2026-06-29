package lld3.tictactoe.models;

public class Symbol {
    private char character;

    public Symbol(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}

/*
* Why have a full class for Symbol, instead of just a char attribute ? --> Extensibility
* */