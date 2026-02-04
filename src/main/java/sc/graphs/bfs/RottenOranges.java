package sc.graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int i;
    int j;
    int time;
    Pair(int x, int y, int time) {
        i = x;
        j = y;
        this.time = time;
    }
}

public class RottenOranges {
    int rows = 0;
    int cols = 0;
    int fresh = 0;
    int minTime = 0;
    public int solve(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.add(new Pair(i,j, minTime));
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        while(!queue.isEmpty()) {
            Pair rem = queue.remove();
            minTime = rem.time;

            for(int i = 0; i < 4; i++) {
                int nr = rem.i + dr[i];
                int nc = rem.j + dc[i];

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    queue.add(new Pair(nr, nc, rem.time+1));
                    fresh--;
                }
            }

        }

        if(fresh == 0)
            return minTime;
        else
            return -1;
    }
}

class RottenOrangesMain {
    public static void main(String[] args) {
        int[][] A = {{},{}, {}, {}};
        RottenOranges ro= new RottenOranges();
        System.out.println(ro.solve(A));
    }
}
