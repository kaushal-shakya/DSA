package sc.graphs.dijkastra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

    class Pair{
        int v;
        int cost;
        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    void dijImpl(ArrayList<ArrayList<Pair>> graph, int n, int[] dist, int source) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.cost < o2.cost)
                    return -1;
                else if(o1.cost > o2.cost)
                    return 1;
                else
                    return 0;
            }
        });
        pq.add(new Pair(source, 0));

        while(!pq.isEmpty()) {
            Pair p = pq.remove();
            int v = p.v;
            int cost = p.cost;

//            if(dist[v] != Integer.MAX_VALUE)
//                continue;

            dist[v] = cost; // Jo node remove ho rhi h uska kaam. i.e Main node

            for (Pair nbr : graph.get(v)) {
                if(dist[nbr.v]  > cost + nbr.cost) {
                    dist[nbr.v] = cost + nbr.cost; // Main node ke nbr pr update
                    pq.add(new Pair(nbr.v, cost + nbr.cost));
                }
            }
        }
    }

    int[] solve(int[][] edges, int n) {
        int[] dist = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i = 0; i <=n ; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int cost = edges[i][2];

            graph.get(u).add(new Pair(v, cost));
            graph.get(v).add(new Pair(u, cost));
        }

        dijImpl(graph, n, dist, 1);

        return dist;
    }
}

class DijkastraMain {
    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{1,2,7},{1,3,8},{2,3,3},{2,4,6},{3,4,4},{3,5,3},{4,5,2},{4,6,5},{5,6,5},{5,7,2},{6,7,3}};
        Dijkstra obj = new Dijkstra();
        int[] dist = obj.solve(edges, n);
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }
}


