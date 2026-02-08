package sc.graphs.topological;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KahnTopological {

    /* Kahn BFS */
    public ArrayList<Integer> kahn(int A, ArrayList<ArrayList<Integer>> graph) {
        int[] indegree = new int[A+1];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            for (int nbr : graph.get(i)) {
                indegree[nbr]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= A ; i++) {
            if(indegree[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            int rem = q.remove();
            result.add(rem);
            for (int nbr : graph.get(rem)) {
                indegree[nbr]--;
                if(indegree[nbr] == 0)
                    q.add(nbr);
            }
        }
        return result;
    }

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList();

        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < B.size(); i++) {
            int u = B.get(i).get(0);
            int v = B.get(i).get(1);

            graph.get(u).add(v);
        }

        return kahn(A, graph);
    }
}

class TopologicalMain {
    public static void main(String[] args) {
//        int A = 6;
//        ArrayList<ArrayList<Integer>> edges = new ArrayList<>(
//                Arrays.asList(
//                        new ArrayList<>(Arrays.asList(6,3)),
//                        new ArrayList<>(Arrays.asList(6,1)),
//                        new ArrayList<>(Arrays.asList(5,1)),
//                        new ArrayList<>(Arrays.asList(5,2)),
//                        new ArrayList<>(Arrays.asList(3,4)),
//                        new ArrayList<>(Arrays.asList(4,2))
//                ));
        int A = 8;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1,4)),
                        new ArrayList<>(Arrays.asList(1,2)),
                        new ArrayList<>(Arrays.asList(4,2)),
                        new ArrayList<>(Arrays.asList(4,3)),
                        new ArrayList<>(Arrays.asList(3,2)),
                        new ArrayList<>(Arrays.asList(5,2)),
                        new ArrayList<>(Arrays.asList(3,5)),
                        new ArrayList<>(Arrays.asList(8,2)),
                        new ArrayList<>(Arrays.asList(8,6))
                ));

        KahnTopological kt = new KahnTopological();

        System.out.println(kt.solve(A, edges));
    }
}