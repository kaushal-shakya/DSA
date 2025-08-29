package scaler.queues;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {
    public static void main(String[] args) {

    }

    public static int[] getMaximumInSubArrayOfLenK(int [] A, int k)
    {
        int n = A.length;
        int[] result = new int[n-k+1];
        Deque<Integer> deque = new LinkedList<>();
        int idx = 0;
        for(int i = 0; i < n-1; i++){
            while(!deque.isEmpty() && deque.peekFirst() <= i-k)
            {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && A[deque.peekLast()] < A[i]){
                deque.pollLast();
            }
            deque.addLast(A[i]);
            if(i >= k-1)
            {
                result[idx] = A[deque.peekFirst()];
                idx++;
            }
        }
        return result;
    }

}
