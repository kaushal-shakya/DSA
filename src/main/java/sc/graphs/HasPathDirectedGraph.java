package sc.graphs;

import java.util.ArrayList;

public class HasPathDirectedGraph {

    private boolean isPath(ArrayList<Integer>[] graph, int start, int dest, boolean[] visited) {

        if(start == dest)
            return true;

        visited[start] = true;
        ArrayList<Integer> nbr = graph[start];

        for (int item : nbr) {
            if (!visited[item])
                if(isPath(graph, item, dest, visited)) {
                    return true;
                }
        }

        return false;
    }

    private int hasPath(ArrayList<Integer>[] graph) {
        boolean[] visited = new boolean[graph.length];
        visited[0] = false;

        return isPath(graph, 1, graph.length-1,visited) ? 1 : 0;
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

        return hasPath(graph);
    }
}


class HasPathDirectedGraphMain {
    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2}, {4,1}, {2,4}, {3,4}, {5,2}, {1,3} }  ;
        HasPathDirectedGraph dfs = new HasPathDirectedGraph();
        System.out.println(dfs.solve(A, B));
    }
}