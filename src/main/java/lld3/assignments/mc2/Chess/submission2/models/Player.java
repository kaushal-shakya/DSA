package lld3.assignments.mc2.Chess.submission2.models;

import lld3.assignments.mc2.Chess.submission2.enums.Color;
import lld3.assignments.mc2.Chess.submission2.enums.PlayerType;

import java.util.List;

public abstract class Player {
    private String name;
    private Color color;
    private List<Piece> pieces;
    private PlayerType playerType;

    public Player(String name, Color color, PlayerType playerType) {
        this.name = name;
        this.color = color;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }
}
