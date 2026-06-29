package lld3.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    
    private int size;
    private List<List<Cell>> cells;
    
    /*
    3 * 3
           0      1        2
    0 [Cell 0] [Cell 1] [Cell 2] --> List 0
    1 [Cell 3] [Cell 4] [Cell 5] --> List 1
    2 [Cell 6] [Cell 7] [Cell 8] --> List 2
     */
    
    public Board(int size) {
        this.size = size;
        this.cells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(new Cell(i, j));
            }
            cells.add(row);
        }
    }

    public int getSize() {
        return size;
    }

    public Cell getCell(int row, int col) {
        return cells.get(row).get(col);
    }

    public void printBoard() {
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                if(cell.getCellState() == CellState.EMPTY) {
                    System.out.print(" . ");
                } else {
                    System.out.print(" " + cell.getPlayer().getSymbol().getCharacter() + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
