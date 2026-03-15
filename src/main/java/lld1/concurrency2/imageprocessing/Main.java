package lld1.concurrency2.imageprocessing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int[][] originalArray = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int rows = originalArray.length;
        int cols = originalArray[0].length;

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        int midRow = rows/2;
        int midCol = cols/2;

        ArrayRepainterTask task1 = new ArrayRepainterTask(originalArray, 0, midRow-1, 0, midCol-1);
        ArrayRepainterTask task2 = new ArrayRepainterTask(originalArray, 0, midRow-1, midCol, cols-1);
        ArrayRepainterTask task3 = new ArrayRepainterTask(originalArray, midRow, rows-1, 0, midCol-1);
        ArrayRepainterTask task4 = new ArrayRepainterTask(originalArray, midRow, rows-1, midCol, cols-1);

        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);
        executorService.submit(task4);

        executorService.shutdown();

        while(!executorService.isTerminated()) {

        }

        for(int[] row : originalArray) {
            for(int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
