package sc.graphs.bfs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair1 {
    int u;
    int dist;

    Pair1(int u, int dist) {
        this.u = u;
        this.dist = dist;
    }
}

public class AnotherBFS {
    private int bfs(ArrayList<ArrayList<Integer>> graph, int C, int D, ArrayList<Boolean> visited) {
        Queue<Pair1> q = new LinkedList<>();
        q.add(new Pair1(C, 0));
        visited.add(true);

        while(!q.isEmpty()) {
            Pair1 rem = q.remove();
            int u = rem.u;
            int dist = rem.dist;

            if(u == D)
                return dist;

            for ( int nbr : graph.get(u)) {
                if(!visited.get(nbr)) {
                    visited.set(nbr, true);
                    q.add(new Pair1(nbr, dist+1));
                }
            }
        }

        return -1;
    }

    public int solve(int A, int[][] B, int C, int D) {
        int val = A;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];

            if(w == 1) {
                graph.get(u).add(v);
                graph.get(v).add(u);
            } else {
                graph.add(new ArrayList<>());
                graph.get(u).add(val);
                graph.get(val).add(u);
                graph.get(v).add(val);
                graph.get(val).add(v);
                val = val+1;
            }
        }
//        ArrayList<Boolean> visited = new ArrayList<>(graph.size());
        for (int i = 0; i < graph.size(); i++) {
            visited.add(false);
        }
        return bfs(graph, C, D, visited);
    }
}

class AnotherBFSMain {
    public static void main(String[] args) {
//        int A = 6;
//        int[][] B = {   {2, 5, 1}, {1, 3, 1}, {0, 5, 2}, {0, 2, 2}, {1, 4, 1}, {0, 1, 1} };
//        int C = 3;
//        int D = 2;
        int A = 13;
        int[][] B = {   {3,11,2}, {5,12,1},{0,7,2},{5,6,2},{6,10,1},{5,9,1} };
        int C = 9;
        int D = 4;

        AnotherBFS abfs = new AnotherBFS();
        System.out.println(abfs.solve(A, B, C, D));
    }
}