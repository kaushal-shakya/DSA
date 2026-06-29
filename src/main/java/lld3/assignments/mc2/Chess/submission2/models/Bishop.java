package lld3.assignments.mc2.Chess.submission2.models;

import lld3.assignments.mc2.Chess.submission2.enums.PieceType;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop() {
        super();
    }

    public Bishop(Cell Cell) {
        super(Cell);
        type = PieceType.BISHOP;
    }

    @Override
    public List<Cell> possibleMoves(Cell currentCell) {
        // logic to return all the possible moves
        return new ArrayList<>();
    }
}
