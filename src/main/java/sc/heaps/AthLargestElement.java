package sc.heaps;

import java.util.*;

public class AthLargestElement {

    // Refactored code for belo method
    public List<Integer> solve(int k, List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        // Min-heap to keep track of the 'k' largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else if (num > minHeap.peek()) {
                // "Delayed Decision": only swap if this new element
                // is better than the smallest of our 'k' best.
                minHeap.poll();
                minHeap.add(num);
            }

            // Add to result: -1 if we haven't reached 'k' elements yet,
            // otherwise the kth largest (the heap's root).
            if (minHeap.size() < k) {
                result.add(-1);
            } else {
                result.add(minHeap.peek());
            }
        }

        return result;
    }

    //This is my approach :
    public static ArrayList<Integer> solve(int A, ArrayList<Integer> B) {

        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i < A-1; i++) {
            result.add(-1);
        }

        for (int i = 0; i < A; i++) {
            pq.add(B.get(i));
        }
        result.add(pq.peek());

        for (int i = A; i < B.size(); i++) {
            int currEle = B.get(i);
            int peekEle = pq.peek();

            if(currEle > peekEle) {
                pq.remove();
                pq.add(B.get(i));
                result.add(pq.peek());
            } else {
                result.add(peekEle);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        int A = 4;
        System.out.println(solve(A, input));
    }
}
