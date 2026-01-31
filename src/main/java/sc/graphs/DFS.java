package sc.graphs;

import java.util.ArrayList;

public class DFS {


    private void dfs(ArrayList<Integer>[] graph, int start, boolean[] visited) {
        visited[start] = true;
        System.out.println(start);

        for (int item : graph[start]) {
            if(!visited[item]) // to prevent the traversal of same node multiple times
                dfs(graph, item, visited);
        }
    }

    public void solve(int A, int[][] B) {
        ArrayList<Integer>[] graph = new ArrayList[A+1];

        for(int i=1; i<=A; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=1; i<=B.length; i++) {
            int start = B[i-1][0];
            int end = B[i-1][1];

            graph[start].add(end);
        }

        boolean[] visited = new boolean[graph.length];
        visited[0] = true;

        for(int i=1; i<graph.length; i++) {
            if(visited[i] == false)
                dfs(graph, i, visited);

        }
        return;
    }
}

class DFSMain {
    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2}, {4,1}, {2,4}, {3,4}, {5,2}, {1,3} }  ;
        DFS dfs = new DFS();
        dfs.solve(A, B);
    }
}
