package lld3.assignments.mc2.Chess.submission2.models;

import lld3.assignments.mc2.Chess.submission2.enums.PieceType;

import java.util.List;

public class Pawn extends Piece{

    public Pawn() {
        super();
    }

    public Pawn(Cell Cell) {
        super(Cell);
        type = PieceType.PAWN;
    }

    @Override
    public List<Cell> possibleMoves(Cell currentCell) {
        return List.of();
    }
}
