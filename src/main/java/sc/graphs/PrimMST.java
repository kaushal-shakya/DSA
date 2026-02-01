package sc.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {
    int start;
    int end;
    int cost;

    public Pair(int j, int i, int cost) {
        start = j;
        end = i;
        this.cost = cost;
    }
}

class MSTPriorityLogic implements Comparator<Pair> {

    @Override
    public int compare(Pair o1, Pair o2) {
        if (o1.cost < o2.cost)
            return -1;
        else if (o1.cost > o2.cost)
            return 1;
        else
            return 0;
    }
}

public class PrimMST {
    PriorityQueue<Pair> pq = new PriorityQueue<>(new MSTPriorityLogic());
    int ans = 0;
    private void primMST(ArrayList<Pair>[] graph, boolean[] visited, int source) {

        pq.add(new Pair(-1,source,0));

        while (!pq.isEmpty()) {
            Pair rem = pq.remove();
            int u = rem.end;
            int cost = rem.cost;

            if(visited[u])
                continue;

            visited[u] = true;
            ans += cost;
            for (Pair nbr : graph[u]) {
                int v = nbr.end;
                int weight = nbr.cost;
                if (visited[v] == false)
                    pq.add(new Pair(u,v,weight));
            }

        }
    }

    public int solve(int vertices, int[][] edges) {
        boolean[] visited = new boolean[vertices+1];
        ArrayList<Pair>[] graph = new ArrayList[vertices+1];

        for (int i = 1; i <= vertices; i++) {
            graph[i] = new ArrayList<Pair>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            graph[u].add(new Pair(u,v,w));
            graph[v].add(new Pair(v,u,w));
        }
        for (int i=1; i < graph.length; i++) {
            if (!visited[i])
                primMST(graph, visited, i);
        }

        return ans;
    }
}

class PrimMain {
    public static void main(String[] args) {
        int A = 7;
        int[][] B = { {1, 2, 3}, {1,3,5}, {2,5,5}, {3,5,3}, {3,6,8}, {2,4,1}, {4,6,2}, {4,7,5}, {6,7,3} }  ;
        PrimMST prim = new PrimMST();
        int ans = prim.solve(A, B);
        System.out.println(ans);
    }
}
