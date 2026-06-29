package lld3.tictactoe.models;

public abstract class Player {

    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    // When the player is created, then all the properties to be defined
    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
}
