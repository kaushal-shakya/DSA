package lld3.assignments.mc2.Chess.submission2.models;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(){
        super();
    }

    public King(Cell Cell) {
        super(Cell);
        type = PieceType.KING;
    }

    @Override
    public List<Cell> possibleMoves(Cell currentCell) {
        // logic to return all the possible moves
        return new ArrayList<>();
    }
}
