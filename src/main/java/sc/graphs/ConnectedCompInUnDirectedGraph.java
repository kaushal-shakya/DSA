package sc.graphs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ConnectedCompInUnDirectedGraph {
    ArrayList<Integer> al = new ArrayList<>();
    public ArrayList<Integer> getConnectedComponent(ArrayList<ArrayList<Integer>> graph, int start, boolean[] visited) {
        visited[start] = true;

        al.add(start);

        ArrayList<Integer> nbrList = graph.get(start);
        for (int nbr : nbrList) {
            if(!visited[nbr]) {
//                al.add(nbr);
                getConnectedComponent(graph, nbr, visited);
            }
        }

        return al;
    }

    public ArrayList<ArrayList<Integer>> getComponents(int A, ArrayList<ArrayList<Integer>> B) {
        boolean[] visited = new boolean[A];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(A);

        for(int i=0; i<A; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<B.size(); i++) {
            int u = B.get(i).get(0);
            int v = B.get(i).get(1);

            graph.get(u).add(v);
            graph.get(v).add(u); // due to undirected graph
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            if (!visited[i]) {
                ArrayList<Integer> temp = getConnectedComponent(graph, i, visited) ;
                Collections.sort(temp);
                al = new ArrayList<>();
                result.add(temp);
            }
        }

        return result;
    }
}

class ConnectedCompInUnDirectedGraphMain {
    public static void main(String[] args) {
        int A = 5;
        ArrayList<ArrayList<Integer>> input  = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(0,1)),
                        new ArrayList<>(Arrays.asList(2,1)),
                        new ArrayList<>(Arrays.asList(3,4))
                        ));
//        ArrayList<ArrayList<Integer>> input  = new ArrayList<>(
//                Arrays.asList(
//                        new ArrayList<>(Arrays.asList(0, 1)),
//                        new ArrayList<>(Arrays.asList(6, 0)),
//                        new ArrayList<>(Arrays.asList(2, 4)),
//                        new ArrayList<>(Arrays.asList(2, 3)),
//                        new ArrayList<>(Arrays.asList(3, 4))
//                        ));

        System.out.println(input);
        ConnectedCompInUnDirectedGraph graph = new ConnectedCompInUnDirectedGraph();
        System.out.println(graph.getComponents(A, input));

    }
}