package sc.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ConnectingRopes {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1,2,3,4,5) );
        System.out.println(solve(al));
    }

    public static int solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int item : A)
            pq.add(item);

        int cost = 0;
        while(pq.size() > 1) {
            int first = pq.remove();
            int second = pq.remove();
            cost += first + second;

            pq.add(first + second);
        }
        return cost;
    }
}
