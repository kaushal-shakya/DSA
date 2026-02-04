package sc.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;


class Pair {
    int beg;
    int end;
    Pair(int beg, int end) {
        this.beg = beg;
        this.end = end;
    }
}
class PairOrderingLogic implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        if(o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else
            return 0;
    }
}


public class FinishMaxJobs {


    public int solve(int[] A, int[] B) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairOrderingLogic());
        for (int i = 0; i < A.length; i++) {
            pq.add(new Pair(A[i], B[i]));
        }
        pq.forEach(pair -> System.out.println(pair.beg + " "+ pair.end));
        int prevStart = 0;
        int prevEnd = 0;
        int jobs = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.remove();
            int currStart = pair.beg;
            int currEnd = pair.end;

            if(currStart >= prevEnd) {
                prevStart = currStart;
                prevEnd = currEnd;
                jobs++;
            }
        }


        return jobs;
    }
}

class FinishMxJobsMain {
    public static void main(String[] args) {
//        int[] A = {1, 5, 7, 1};
//        int[] B = {7, 8, 8, 8};
        int[] A = {3,2,6};
        int[] B = {10,8,9};

//        int[] A = {5, 1,4, 10 };
//        int[] B = {100,3,10,10000000};

        FinishMaxJobs fmj = new FinishMaxJobs();
        System.out.println(fmj.solve(A, B));
    }
}
