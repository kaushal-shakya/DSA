package sc.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Leetcode : 452
public class MinimumArrowShots {

    class Pair {
        int start;
        int end;
        public Pair(int strt, int end) {
            start = strt;
            this.end = end;
        }
    }

    public int findMinArrowShots(int[][] points) {
        List<Pair> sortedList = new ArrayList<>();
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < 2; j++) {
                sortedList.add(new Pair(points[i][0], points[i][1]));
            }
        }

        Collections.sort(sortedList, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if(p1.end < p2.end) {
                    return -1;
                } else if(p1.end > p2.end) {
                    return 1;
                } else
                    return 0;
            }
        });


        int numOfArrows = 0;
        int n = sortedList.size();
        for(int i = 0; i < n;  ) {
            Pair p = sortedList.get(i);
            int k = i+1;
            // numOfArrows++;
            while (k < n && sortedList.get(k).start <= p.end) {
                k++;
            }
            numOfArrows++;
            i = k;
        }

        return numOfArrows;
    }
}

class MinArrowShotsMain {
    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        MinimumArrowShots minimumArrowShots = new MinimumArrowShots();
        System.out.println(minimumArrowShots.findMinArrowShots(points));
    }
}