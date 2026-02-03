package sc.backtrack;

import java.util.Arrays;

public class SudokuSolver {

    private static boolean isPlacementSafe(char[][] board, int si, int sj, int num) {
        //check row
        for (int i = 0; i < board.length; i++) {
            if(board[si][i]-'0' == num)
                return false;
        }

        //check column
        for (int i = 0; i < board.length; i++) {
            if(board[i][sj]-'0' == num)
                return false;
        }

        //check 3*3 block
        int si_scell = (si/3)*3;
        int sj_scell = (sj/3)*3;

        for (int i = si_scell; i <= si+2; i++) {
            for (int j = sj_scell; j <= sj+2; j++) {
                if(board[i][j] == num)
                    return false;
            }
        }

        return true;
    }

    public static void solveSudoku(char[][] board, int si, int sj) {
        if(si == 9)
            return;

        if( si <= 8 && sj <= 8 && board[si][sj] == '.')
        {
            for (int i = 1; i < 9; i++) {
                if(isPlacementSafe(board, si, sj, i))
                    board[si][sj] = (char) i;
            }
        }

        if(sj <= 8) { // row forwarding
                solveSudoku(board, si, sj+1);
        } else { // switching row
                solveSudoku(board, si+1, 0);
            }
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        int emptyCells = 0;
        //scan through all the 2d array and check empty cells
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.')
                    emptyCells++;
            }
        }

        System.out.println(emptyCells);

        solveSudoku(board, 0, 0);

        System.out.println(Arrays.deepToString(board));

    }
}
