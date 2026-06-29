package lld3.assignments.mc2.Chess.submission2.models;

import lld3.assignments.mc2.Chess.submission2.Player;
import lld3.assignments.mc2.Chess.submission2.enums.Color;
import lld3.assignments.mc2.Chess.submission2.enums.PieceType;

import java.util.List;

public abstract class Piece {

    protected Color color;
    protected PieceType type;
    protected Cell currentCell; // This i have kept to just to know if we have Piece than its Cell could be get in O(1)
    protected Player player;

    public Piece() {}

    public Piece(Cell cell) {
        this.currentCell = cell;
        this.color = color;
    }
    //This could be useful for suggestion if person --> not required for MVP
    public abstract List<Cell> possibleMoves(Cell currentCell);

    public PieceType getType() {
        return type;
    }

}
