package sc.graphs.dijkastra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMaxiumProbablity {
    class Pair{
        int v;
        double cost;

        public Pair(int v, double cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    void dijImpl(ArrayList<ArrayList<Pair>> graph, int n, double[] dist, int source) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.cost < o2.cost)
                    return 1;
                else if(o1.cost > o2.cost)
                    return -1;
                else
                    return 0;
            }
        });
        pq.add(new Pair(source, 1.0));

        while(!pq.isEmpty()) {
            Pair p = pq.remove();
            int v = p.v;
            double cost = p.cost;

            for (Pair nbr : graph.get(v)) {
                if(dist[nbr.v] < cost * nbr.cost) {
                    dist[nbr.v] = cost * nbr.cost;
                    pq.add(new Pair(nbr.v, cost * nbr.cost));
                }
            }
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] result = new double[n];
        Arrays.fill(result, 0.0);

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i = 0; i <=n ; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double cost = succProb[i];

            graph.get(u).add(new Pair(v, cost));
            graph.get(v).add(new Pair(u, cost));
        }

        dijImpl(graph, n, result, start_node);

        return result[end_node];
    }
}

class PathMain {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.2};
        int start = 0, end = 2;

        PathWithMaxiumProbablity ndm = new PathWithMaxiumProbablity();
        System.out.println(ndm.maxProbability(n, edges, succProb, start, end));
    }
}