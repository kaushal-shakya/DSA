package sc.graphs.dfs;


import java.util.Arrays;

class SurroundedRegionMain {
    int rows = 0;
    int columns = 0;

    /* My first approach : here i checked straight horizontal and vertical rows and columns and ignored any turn
    private boolean isReplacementSafe(char[][] board, int worker_x, int worker_y) {

        boolean isleftXFound = true, isRightXFound = true, isUpXFound = true, isDownXFound = true;

        // check all direction
        //check left
        if(board[worker_x][worker_y-1] != 'X') {
            for(int i = worker_y-1; i >= 0; i--) {
                if(board[worker_x][i] == 'O')
                    isleftXFound = false;
                else
                    isleftXFound = true;
            }
        }

        //check right
        if(worker_y+1 <= board.length-1 && board[worker_x][worker_y+1] != 'X') {
            for(int i = worker_y+1; i <= board[0].length-1; i--) {
                if(board[worker_x][i] == 'O')
                    isRightXFound = false;
                else
                    isRightXFound = true;
            }
        }

        //check vertical up
        if(worker_x-1 >=0 && board[worker_x-1][worker_y] != 'X') {
            for(int i = worker_x-1; i >=0; i--) {
                if(board[i][worker_y] == 'O')
                    isUpXFound = false;
                else {
                    isUpXFound = true;
                }
            }
        }

        //check vertical down
        if(worker_x+1 <= board[0].length-1  && board[worker_x+1][worker_y] != 'X') {
            for(int i = worker_y+1; i<=board.length-1; i++) {
                if(board[i][worker_y] == 'O')
                    isDownXFound = false;
                else
                    isDownXFound = true;
            }
        }

        return isleftXFound && isRightXFound && isUpXFound && isDownXFound;
    }

    private void helper(char[][] board, int worker_x, int worker_y) {
        if(worker_x == rows-2 && worker_y == columns-2 && board[worker_x][worker_y] == 'X') {
            return;
        }
        else if (worker_x == rows-2 && worker_y == columns-2 && board[worker_x][worker_y] == 'O') {
            if(isReplacementSafe(board, worker_x, worker_y))
                board[worker_x][worker_y] = 'X';
            return;
        }

        //Here, we are skipping boundary of matrix
        for(int i=worker_x; i<board.length-1; i++) {
            if(worker_y == board[0].length-2) {
                helper(board, worker_x+1, 1); // calling when rows are switched
            } else {
                helper(board, i, worker_y+1); // traversing column
            }
        }

        if(board[worker_x][worker_y] == 'O' && isReplacementSafe(board, worker_x, worker_y))
            board[worker_x][worker_y] = 'X';
    }

    public void solve(char[][] board) {
        rows = board.length;
        columns = board[0].length;
        helper(board, 1,1);
    }
    */

    public void dfs(char[][] board, int x, int y,  int[][] visited) {
        if (x < 0 || x >= rows || y < 0 || y >= columns || visited[x][y] == 1 || board[x][y] != 'O') {
            return;
        }

        visited[x][y] = 1;

        dfs(board, x-1, y, visited);
        dfs(board, x+1, y, visited);
        dfs(board, x, y-1, visited);
        dfs(board, x, y+1, visited);
    }

    public void solve(char[][] board) {
        rows = board.length;
        columns = board[0].length;

        int[][] visited = new int[rows][columns];

        //check boundary for 0
        //check first row
        for (int i = 0; i < columns; i++) {
            if(visited[0][i] == 0 && board[0][i] == 'O')
                dfs(board, 0, i, visited);

            if(visited[rows-1][i] == 0 && board[rows-1][i] == 'O')
                dfs(board, rows-1, i, visited);
        }
        //check first column
        for (int i = 0; i < rows; i++) {
            if(visited[i][0] == 0 && board[i][0] == 'O')
                dfs(board, i, 0, visited);

            if(visited[i][columns-1] == 0 && board[i][columns-1] == 'O')
                dfs(board, i, columns-1, visited);
        }

//        System.out.println( " visited : ---- " + Arrays.deepToString(visited));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(visited[i][j] == 0 && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
}

//Leetcode : 130
public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {{'X','X','X', 'X'},{'X','O','O', 'X'},{'X','X','O', 'X'}, {'X','O','X','X'}};

        SurroundedRegionMain smain = new SurroundedRegionMain();
        smain.solve(board);

        System.out.println(Arrays.deepToString(board));
    }
}
