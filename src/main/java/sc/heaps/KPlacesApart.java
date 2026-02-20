package sc.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
N people having different priorities are standing in a queue.
The queue follows the property that each person is standing at most B places away from its position in the sorted queue.
Your task is to sort the queue in the increasing order of priorities.
NOTE:
No two persons can have the same priority.
Use the property of the queue to sort the queue with complexity O(NlogB).

Example Input
Input 1:
 A = [1, 40, 2, 3]
 B = 2
Output 1:
 [1, 2, 3, 40]

Input 2:
 A = [2, 1, 17, 10, 21, 95]
 B = 1
Output 2:
 [1, 2, 10, 17, 21, 95]
*/


public class KPlacesApart {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        if(B == 0)
            return A;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i <= B; i++) {
            pq.add(A.get(i));
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int i = B+1; i < A.size(); i++) {
            int remove = pq.poll();
            res.add(remove);
            pq.add(A.get(i));
        }

        while(!pq.isEmpty()) {
            int remove = pq.poll();
            res.add(remove);
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3,2,1,17,10,21,95));
        int B = 1;
        System.out.println(solve(input, B));
    }
}
