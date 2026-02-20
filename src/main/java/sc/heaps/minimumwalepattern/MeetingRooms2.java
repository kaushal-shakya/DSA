package sc.heaps.minimumwalepattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {

        // Sort using a Comparator to compare the element at index 0
        B.sort(Comparator.comparing(o -> o.get(0)));

        //To keep track of the end times of meetings currently occupying rooms.
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //Initialize it with first end time
        pq.add(B.get(0).get(1));

        for(int i = 1; i < A; i++) {
            int start = B.get(i).get(0);
            int end = B.get(i).get(1);

            if(start >= pq.peek()) {
                pq.remove();
                pq.add(end);
            } else {
                pq.add(end);
            }

        }
        return pq.size();
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> B  = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(0,30)),
                        new ArrayList<>(Arrays.asList(5,10)),
                        new ArrayList<>(Arrays.asList(15,50))
                )
        );

        int A = 3;

        System.out.println(solve(A, B));

    }
}
