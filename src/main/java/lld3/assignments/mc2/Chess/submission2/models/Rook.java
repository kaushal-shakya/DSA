package lld3.assignments.mc2.Chess.submission2.models;

import lld3.assignments.mc2.Chess.submission2.enums.PieceType;

import java.util.List;

public class Rook extends Piece {
    public Rook() {
        super();
    }

    public Rook(Cell Cell) {
        super(Cell);
        type = PieceType.ROOK;
    }

    @Override
    public List<Cell> possibleMoves(Cell currentCell) {
        return List.of();
    }
}
