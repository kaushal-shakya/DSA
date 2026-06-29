package lld3.assignments.mc2.Chess.submission2.models;

import lld3.assignments.mc2.Chess.submission2.enums.PieceType;

import java.util.List;

public class Knight extends Piece {
    public Knight() {
        super();
    }

    public Knight(Cell Cell) {
        super(Cell);
        type = PieceType.KNIGHT;
    }

    @Override
    public List<Cell> possibleMoves(Cell currentCell) {
        return List.of();
    }
}
