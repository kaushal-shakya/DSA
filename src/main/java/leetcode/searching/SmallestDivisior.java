package leetcode.searching;

//1283. Find the Smallest Divisor Given a Threshold
public class SmallestDivisior {
    public static void main(String[] args) {
//        int[] nums = {1,2,5,9};
//        int threshold = 6;

//        int[] nums = {44,22,33,11,1};
//        int threshold = 5;

        int[] nums = {21212,10101,12121};
        int threshold = 1000000;
        System.out.println(smallestDivisor(nums, threshold));
    }

    public static int smallestDivisor(int[] A, int threshold) {
        //Find search space
        int min = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++)
        {
//            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        int start = min;
        int end = max;

        int ans = Integer.MAX_VALUE;
        while (start <= end)
        {
            int mid = start + (end-start)/2;
            int potentialAns = 0;
            for(int i = 0; i < A.length; i++){
                int a = (int)Math.ceil((double) A[i] /mid);
                potentialAns += a;
            }
            if( potentialAns > threshold ) {
                start = mid + 1;
            } else {
                ans = Math.min(ans, mid);
                end = mid-1;
            }

        }
        return ans;
    }

}
