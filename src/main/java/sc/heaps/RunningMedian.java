package sc.heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {

    public static void balance(PriorityQueue<Integer> maxH, PriorityQueue<Integer> minH) {
        if(minH.size() > maxH.size())
            maxH.add(minH.remove());
        else
            minH.add(maxH.remove());
    }

    public static int[] solve(int[] A) {
        PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minH = new PriorityQueue<>();
        int[] result = new int[A.length];
        maxH.add(A[0]);
        result[0] = A[0];

        for(int i=1; i<A.length; i++) {
            if(A[i] > maxH.peek()) {
                minH.add(A[i]);
            } else {
                maxH.add(A[i]);
            }

            int diff = Math.abs(maxH.size() - minH.size());
            if(diff > 1) balance(maxH, minH);

            if(i % 2 == 0){
                result[i] = (maxH.peek()+ minH.peek())/2;
            } else {
                result[i] = maxH.peek();
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        int[] A = {5,4,1,3,2};
        int[] A = {32,91,86,8,4,100,98,15,79,32,4,99};
        int[] result = solve(A);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
