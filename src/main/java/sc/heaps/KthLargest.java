package sc.heaps;

import java.util.PriorityQueue;



public class KthLargest {
    /*
        Algorithm idea :
        1. initialize pq with k element.
        2. if any of the next element is better than current worst.
        3. Remove current worst and add new better element.
    */

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++) {
            if(nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k  = 4;
        System.out.println(findKthLargest(nums, k));
    }
}
