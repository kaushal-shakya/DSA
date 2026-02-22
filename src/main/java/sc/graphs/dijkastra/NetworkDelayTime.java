package sc.graphs.dijkastra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    class Pair {
        int v;
        int time;

        public Pair(int v, int time) {
            this.v = v;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int t = times[i][2];

            graph.get(u).add(new Pair(v, t));
        }

        int[] time = new int[n + 1];
        Arrays.fill(time, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if (p1.time < p2.time) {
                    return -1;
                } else if (p1.time > p2.time) {
                    return 1;
                } else
                    return 0;
            }
        });

        pq.add(new Pair(k, 0));
        while (!pq.isEmpty()) {
            Pair rem = pq.remove();
            int v = rem.v;
            int t = rem.time;

            if (time[v] != Integer.MAX_VALUE) {
                continue;
            } else {
                time[v] = t;
                for (Pair p : graph.get(v)) {
                    if (time[p.v] == Integer.MAX_VALUE) {
                        pq.add(new Pair(p.v, t + p.time));
                    }
                }
            }
        }

        int maxTime = Integer.MIN_VALUE;
        for (int i = 1; i < time.length; i++) {
            if (time[i] == Integer.MAX_VALUE)
                return -1;
            maxTime = Math.max(maxTime, time[i]);
        }
        return maxTime;
    }
}

class NetworkDelayTimeMain {
    public static void main(String[] args) {
        int[][] times = {{2,1,1}, {2,3,1},{3,4,1}};
        int n = 4, k = 2;

        NetworkDelayTime ndm = new NetworkDelayTime();
        System.out.println(ndm.networkDelayTime(times, n, k));
    }
}