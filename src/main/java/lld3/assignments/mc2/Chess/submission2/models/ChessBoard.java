package lld3.assignments.mc2.Chess.submission2.models;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {
    private List<List<Cell>> cells;

    public ChessBoard(int size) {
        //Setup board
        createBoard(size);
        //put all white key on cells of one side --> row 0, 1
        placesAllBlackPieces();
        //pub all black key on cells on opposite side --> row 6,7
        placesAllWhitePieces();
    }

    private void createBoard(int size){
        cells = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            cells.add(new ArrayList<>(size));
        }
    }

    private void placesAllBlackPieces() {

    }

    private void placesAllWhitePieces() {

    }
}
