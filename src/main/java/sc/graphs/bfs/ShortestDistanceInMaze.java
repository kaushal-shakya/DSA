package sc.graphs.bfs;


import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInMaze {

    static class Info {
        int x;
        int y;
        int steps;

        public Info(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }

    public static int solve(int[][] A, int[] B, int[] C) {
        int n = A.length;
        int m = A[0].length;

        int[] rows = {0, -1, 0, 1};
        int[] cols = {-1, 0, 1, 0};

        int[][] dist = new int[n][m];

        for(int i=0; i < n; i++) {
            for(int j=0; j<m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        int srcX = B[0], srcY = B[1], destX = C[0], destY = C[1];
        dist[srcX][srcY] = 0;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(srcX, srcY, 0));

        while(!q.isEmpty()) {
            Info curr = q.remove();
            int x = curr.x;
            int y = curr.y;
            int step = curr.steps;

            for(int k=0; k <=3; k++) {
                int cnt = 0;
                int currX = x;
                int currY = y;
                while( currX+rows[k] >= 0 && currX+rows[k] < n &&  currY+cols[k] >= 0 && currY+cols[k] < m
                        && A[currX+rows[k]][currY+cols[k]] == 0 ) {
                    currX += rows[k];
                    currY += cols[k];
                    cnt++;
                }
                int dis = cnt + step;
                if ( dis < dist[currX][currY]) {
                    dist[currX][currY] = dis;
                    q.add(new Info(currX, currY, dis));
                }

            }
        }

        return dist[destX][destY] == Integer.MAX_VALUE ? -1 : dist[destX][destY];
    }

    public static void main(String[] args) {
        int[][] A = {{1,1,0,1}, {0,0,0,1}, {1,0,0,1}, {0,0,1,0}};
        int[] B = {1,1};
        int[] C = {2,1};

        System.out.println(solve(A, B, C));
    }
}


