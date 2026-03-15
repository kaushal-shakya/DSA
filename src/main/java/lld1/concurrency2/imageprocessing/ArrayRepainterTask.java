package lld1.concurrency2.imageprocessing;

public class ArrayRepainterTask implements Runnable {

    private final int[][] array;
    private final int startRow;
    private final int endRow;
    private final int startCol;
    private final int endCol;

    ArrayRepainterTask(int[][] array, int startRow, int endRow,  int startCol, int endCol) {
        this.array = array;
        this.startRow = startRow;
        this.endRow = endRow;
        this.startCol = startCol;
        this.endCol = endCol;
    }

    @Override
    public void run() {
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                array[i][j] = 2 * array[i][j];
            }
        }
    }
}
