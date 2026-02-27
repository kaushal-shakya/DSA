package sc.graphs.dfs;

public class NumberOfIslands {
    int n = 0;
    int m = 0;
    private void dfs(int[][] A, int x, int y, int[][] visited) {
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] == 1 || A[x][y] != 1) {
            return;
        }

        visited[x][y] = 1;

        dfs(A, x-1, y, visited); // up
        dfs(A, x+1, y, visited); // down
        dfs(A, x, y-1, visited); // left
        dfs(A, x, y+1, visited); // right

        dfs(A, x-1, y+1, visited);
        dfs(A, x+1, y+1, visited);
        dfs(A, x-1, y-1, visited);
        dfs(A, x+1, y-1, visited);
    }

    public int solve(int[][] A) {
        n = A.length;
        m = A[0].length;
        int count = 0;

        int[][] visited = new int[n][m];

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j] == 0 && A[i][j] == 1) {
                    count++;
                    dfs(A, i, j, visited);
                }
            }
        }
        return count;
    }
}

class IslandsMain {
    public static void main(String[] args) {
//        int[][] A = { {0,1,0}, {0,0,1}, {1,0,0} };  //Ans : 2
        int[][] A = {{1,1,0,0,0}, {0,1,0,0,0}, {1,0,0,1,1}, {0,0,0,0,0}, {1,0,1,0,1}};

        NumberOfIslands ns = new NumberOfIslands();
        System.out.println(ns.solve(A));

    }
}
