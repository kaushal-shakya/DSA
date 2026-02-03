package sc.graphs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private void bfsTraversal(ArrayList<Integer>[] graph, int source, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;

        while (queue.size() > 0) {
            int remove = queue.remove();
            System.out.print(remove + " ");

            for ( int nbr : graph[remove]) {
                if(!visited[nbr]) {
                    visited[nbr] = true;
                    queue.add(nbr);
                }
            }
        }
    }

    public void solve(int A, int[][] B) {
        ArrayList<Integer>[] graph = new ArrayList[A+1];

        for(int i=0; i<A; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<B.length; i++) {
            int start = B[i][0];
            int end = B[i][1];

            graph[start].add(end);
        }

        boolean[] visited = new boolean[A];
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i])
                bfsTraversal(graph, i, visited);
        }
    }
}

class BFSMain {
    public static void main(String[] args) {
        int A = 6;
        int[][] B = { {1, 2}, {4,1}, {0,1}, {2,4}, {3,4}, {5,2}, {1,3} }  ;
        BFS bfs = new BFS();
        bfs.solve(A, B);
    }
}
