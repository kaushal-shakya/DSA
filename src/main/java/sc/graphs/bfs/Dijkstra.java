package sc.graphs.bfs;


import java.util.*;

public class Dijkstra {
    class Pair {
        int v;
        int wt;

        public Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    private void dijkstra(int source, ArrayList<ArrayList<Pair>> graph, ArrayList<Integer> distance) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if(p1.wt < p2.wt)
                    return -1;
                else if(p1.wt > p2.wt)
                    return 1;
                else
                    return 0;
            }
        });

        pq.add(new Pair(source, 0));

        while(!pq.isEmpty()) {
            Pair rem = pq.remove();
            int v = rem.v;
            int w = rem.wt;

            if(distance.get(v) != Integer.MAX_VALUE)
                continue;

            distance.set(v, w);
//            System.out.println("v---" + distance.get(v));
            for(Pair nbr : graph.get(v)) {
//                System.out.println(v + "  "+ nbr.v + "  " + nbr.wt);
                if(distance.get(nbr.v) == Integer.MAX_VALUE) {
                    pq.add(new Pair(nbr.v , w + nbr.wt));
                }
            }

        }
    }

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {

        ArrayList<Integer> distance = new ArrayList<>();

        ArrayList<ArrayList<Pair>> graph = new ArrayList();
        for (int i = 0 ; i < A; i++) {
            distance.add(Integer.MAX_VALUE);
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<B.size(); i++) {
            int u = B.get(i).get(0);
            int v = B.get(i).get(1);
            int wt = B.get(i).get(2);

            graph.get(u).add(new Pair(v, wt));
            graph.get(v).add(new Pair(u, wt));
        }

//        System.out.println("Distance----");
//        System.out.println(distance);
//        System.out.println("Graph----");
        dijkstra(C, graph, distance);
        return distance;
    }
}

class DijkstraMain {
    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();
        int A = 6;

        ArrayList<ArrayList<Integer>> input  = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(0,4,9)),
                        new ArrayList<>(Arrays.asList(3,4,6)),
                        new ArrayList<>(Arrays.asList(1,2,1)),
                        new ArrayList<>(Arrays.asList(2,5,1)),
                        new ArrayList<>(Arrays.asList(2,4,5)),
                        new ArrayList<>(Arrays.asList(0,3,7)),
                        new ArrayList<>(Arrays.asList(0,1,1)),
                        new ArrayList<>(Arrays.asList(4,5,7)),
                        new ArrayList<>(Arrays.asList(0,5,1))
                ));

        int C = 4;
        System.out.println(d.solve(A, input, C));

    }
}