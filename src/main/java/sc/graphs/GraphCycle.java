package sc.graphs;

import java.util.ArrayList;

public class GraphCycle {

    private boolean dfs(ArrayList<Integer>[] graph, int start, boolean[] visited, boolean[] path) {
        visited[start] = true;
        path[start] = true;
        ArrayList<Integer> nbr = graph[start];

        for (int item : nbr) {
            if (path[item]) return true; // to prevent the same item in same path again and again
            if (!visited[item])
                if (dfs(graph, item, visited, path))
                    return true;
        }
        path[start]= false;  // reverting change during backtracking

        return false;
    }

    private int hasCycle(ArrayList<Integer>[] graph) {
        boolean[] visited = new boolean[graph.length];
        visited[0] = true;
        boolean[] path = new boolean[graph.length];
        path[0] = true;

        for(int i=1; i<graph.length; i++) {
            if(visited[i] == false)
                if(dfs(graph, i, visited, path))
                    return 1;
        }

        return 0;
    }

    public int solve(int A, int[][] B) {
        ArrayList<Integer>[] graph = new ArrayList[A+1];

        for(int i=1; i<=A; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=1; i<=B.length; i++) {
            int start = B[i-1][0];
            int end = B[i-1][1];

            graph[start].add(end);
        }

        return hasCycle(graph);
    }
}

class GraphCycleMain {
    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2}, {4,1}, {2,4}, {3,4}, {5,2}, {1,3} }  ;
        GraphCycle dfs = new GraphCycle();
        System.out.println(dfs.solve(A, B));
    }
}
