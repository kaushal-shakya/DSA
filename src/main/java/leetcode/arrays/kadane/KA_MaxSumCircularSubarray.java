package leetcode.arrays.kadane;

public class KA_MaxSumCircularSubarray {
    public static void main(String[] args) {
        int[] A = {-2, 4, -5, 4, -5, 9, 4};
        int[] B = {1,-2,3,-2};
        int[] C = {-3,-2,-3};
        System.out.println(maxSumCircularSubArray(C));
    }

    public static int maxSumCircularSubArray(int[] A)
    {
        int total = 0;
        for(int j : A){
            total += j;
        }
        int max = maxSubArray(A);
        int min = minSubArray(A);

        // Edge case: If all numbers are negative, min will be equal to total.
        // In this case, the 'total - min' approach would give 0, which is wrong.
        // The max sum would simply be the largest single element (captured by max).
        if (max < 0 && total == min) {
            // if max is negative and min == total.
            // The simplest check that covers all negative arrays is:
            // if (min == total) return max;
            // This is because if min == total, it implies the entire array is the min.
            // This typically means all elements are non-positive(negative).
            // If all are non-positive, the max sub array is just the largest element.
            return max;
        }


        // Otherwise, the max circular sum is the maximum of the two cases:
        // 1. The max linear subarray sum (doesn't wrap)
        // 2. The total sum minus the min linear subarray sum (wraps around)
        return Math.max(max, total - min);
    }

    public static int minSubArray(int[] A)
    {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int j : A){
            sum = Math.min(j, sum+j);
            min = Math.min(sum, min);
        }
        return min;
    }

    public static int maxSubArray(final int[] A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int j : A) {
            sum = Math.max(sum + j, j);
            max = Math.max(sum, max);
        }
        return max;
    }
}
