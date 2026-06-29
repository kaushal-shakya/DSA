package lld3.assignments.mc2.Chess.submission2.models;

import lld3.assignments.mc2.Chess.submission2.enums.PieceType;

import java.util.List;

public class Queen extends Piece {
    public Queen() {
        super();
    }

    public Queen(Cell Cell) {
        super(Cell);
        type = PieceType.QUEEN;
    }

    @Override
    public List<Cell> possibleMoves(Cell currentCell) {
        return List.of();
    }
}
