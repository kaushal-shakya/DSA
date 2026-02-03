package sc.graphs.mst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair1 {
    int v;
    int cost;
    public Pair1(int v, int cost) {
        this.v  = v;
        this.cost = cost;
    }
}

class MSTPriorityLogic1 implements Comparator<Pair1> {

    @Override
    public int compare(Pair1 o1, Pair1 o2) {
        if (o1.cost < o2.cost)
            return -1;
        else if (o1.cost > o2.cost)
            return 1;
        else
            return 0;
    }
}

public class ConstructionCost {


    private int helper_mst(ArrayList<ArrayList<Pair1>> graph, boolean[] visited) {
        PriorityQueue<Pair1> pq = new PriorityQueue<>(new MSTPriorityLogic1());
        int ans = 0;
        pq.add(new Pair1(1,0));

        while (!pq.isEmpty()) {
            Pair1 remove = pq.remove();
            int u = remove.v;
            int cost = remove.cost;

            if(visited[u])
                continue;

            visited[u] = true;
            ans =  (ans + cost ) % ((int)(Math.pow(10,9)) + 7);
            ArrayList<Pair1> nbrs = graph.get(u);
            for( Pair1 nbr : nbrs) {
                int v = nbr.v;
                int wght = nbr.cost;

                if(!visited[v])
                    pq.add(new Pair1(v, wght));
            }
        }
        return  ans;
    }

    public int solve(int nodes, int[][] edges) {
        boolean[] visited = new boolean[nodes+1];

        ArrayList<ArrayList<Pair1>> graph = new ArrayList<>();

        for (int i = 1; i <= nodes+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            graph.get(u).add(new Pair1(v,w));
            graph.get(v).add(new Pair1(u, w));
        }

        return helper_mst(graph, visited);
    }
}


class ConstructionCostMain {
    public static void main(String[] args) {
        ConstructionCost cc = new ConstructionCost();
//        int A = 3;
//        int B[][] = {{1,2,14},{2,3,7},{3,1,2}};
        int A = 3;
        int B[][] = {{1,2,20},{2,3,17}};
        System.out.println(cc.solve(A, B));
    }
}
