package sc.graphs.topological;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeNodes {
    //Approach 1. DFS + Cycle detection
//    boolean isCycleDFS(int[][] graph, int[] visited, int[] path, int node) {
//        visited[node] = 1;
//        path[node] = 1;
//
//        for(int n : graph[node]) {
//            if(path[n] == 1)
//                return true;
//
//            if(isCycleDFS(graph, visited, path, n))
//                return true;
//        }
//
//        path[node] = 0;
//        return false;
//    }
//
//
//
//    public List<Integer> eventualSafeNodes(int[][] graph) {
//        int[] visited = new int[graph.length];
//        int[] path = new int[graph.length];
//
//        /* This is for DFS + cycle detection
//
//        for(int i=0; i<graph.length; i++) {
//            if(visited[i] == 0) {
//                isCycleDFS(graph, visited, path, i);
//            }
//        }
//
//        List<Integer> list = new ArrayList();
//        for(int i =0; i < path.length; i++) {
//            if(path[i] == 0) {
//                list.add(i);
//            }
//        }
//        return list;
//        */
//
//        /* ----------- This is for Reverse Kahn --------- */
//        for(int i=0; i < graph.length; i++) {
//
//        }
//    }
}
